package com.s.config.log;

import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Created by liuhaiyang on 2017/5/27.
 * 定义切面
 */

@Aspect
@Component
public class WebLogAspectConfig {
    private final String START_LOG = "{}.{} Start.";
    private final String START_LOG_WITHARGS = "{}.{} Start. method parameters={}";
    private final String END_LOG = "{}.{} End.";
    private final String END_LOG_FORRETURN = "{}.{} return value={}";
    private final String EXCEPTION_LOG = "{}.{} Exception={}";
    private final String EXCEPTION_LOG_WITH_ERROROBJ = "{0}.{1} error.";

    /**
     * Log
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.westlakefinancial.technology.payplan.web..*.*(..))"
            + " and !execution(* com.westlakefinancial.technology.payplan.web.viewdomains..*.*(..))"
            + " and !execution(* com.westlakefinancial.technology.payplan.web.domains..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String argsStr = StringUtils.EMPTY;

        Object[] args = joinPoint.getArgs();
        if (null !=  joinPoint && args.length > 0) {
            argsStr = ArrayUtils.toString(args);

            logger.info(START_LOG_WITHARGS, className, methodName, argsStr);
        } else {
            logger.info(START_LOG, className, methodName);
        }
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(END_LOG, className, methodName);
    }

    @AfterReturning(returning = "returnVal", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object returnVal) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        if (null != returnVal) {
            String returnValue = new Gson().toJson(returnVal);

            logger.info(END_LOG_FORRETURN, className, methodName, returnValue);
        }
    }

    @AfterThrowing(throwing = "ex", pointcut = "webLog()")
    public void doThrowing(JoinPoint joinPoint, Throwable ex) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        if (null != ex) {
            logger.error(EXCEPTION_LOG, className, methodName, ex.getMessage());
            logger.error(MessageFormat.format(EXCEPTION_LOG_WITH_ERROROBJ, className, methodName), ex);
        }
    }
}
