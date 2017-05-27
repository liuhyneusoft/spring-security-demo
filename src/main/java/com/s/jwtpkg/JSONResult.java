package com.s.jwtpkg;

import org.json.JSONObject;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
public class JSONResult{
    public static String fillResultString(Integer status, String message, Object result){
        JSONObject jsonObject = new JSONObject(){{
            put("status", status);
            put("message", message);
            put("result", result);
        }};

        return jsonObject.toString();
    }
}
