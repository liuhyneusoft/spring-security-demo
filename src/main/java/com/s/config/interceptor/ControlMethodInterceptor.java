package com.s.config.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by liuhaiyang on 2017/5/27.
 */

/**
 * 定义的拦截器
 */
public class ControlMethodInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        if (uri.equals("/payplan/toTest1")) {
            return true;
        }

        HttpSession session = request.getSession();
        if (null == session) {
            response.sendRedirect("/payplan/sessionExpried");
            return false;
        }
/*
        String currentSessionId = session.getId();
//		String currentXAuthToken = request.getHeader(PayPlanSession.AUTH_KEY.value());
        String currentIp = request.getRemoteAddr();

        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String holderIpAddress = userDetails.getIpAddress();

        boolean verifyResult =
//				|| StringUtils.isEmpty(currentXAuthToken)
//				|| !currentXAuthToken.equals(session.getAttribute(PayPlanSession.SESSION_KEY.value()))
                !currentSessionId.equals(session.getAttribute(PayPlanSession.SESSION_ID.value()))
                        || !currentIp.equals(holderIpAddress);
        if (verifyResult) {
            response.sendRedirect("/payplan/sessionExpried");
            return false;
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (null != modelAndView) {
            HttpSession session = request.getSession();

            /*String clientId = (String)session.getAttribute(PayPlanSession.SESSION_KEY.value());

            Map<String, Object> model = modelAndView.getModel();
            model.put(PayPlanSession.AUTH_KEY.value(), clientId);

            Boolean tempFlg = (Boolean)model.get("PP_SESSION_TEMP_SAVE");
            if (null == tempFlg || !tempFlg) {
                PayPlanSessionApply applyResult = (PayPlanSessionApply)session.getAttribute(clientId);
                applyResult.setSessionTempVal(null);
            }*/
        }
    }
}
