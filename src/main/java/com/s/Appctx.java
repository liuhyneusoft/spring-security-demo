package com.s;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
import org.springframework.context.ApplicationContext;

public class Appctx {
    public static ApplicationContext ctx=null;
    public static Object getObject(String string){
        return ctx.getBean(string);
    }
}
