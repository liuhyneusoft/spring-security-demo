package com.s.support;

/**
 * Created by liuhaiyang on 2017/5/25.
 *
 * 登陆验证（UserDetailService）通过之后，可做自定义操作。
 */

import com.s.domain.SysRole;
import com.s.domain.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SysUser userDetails = (SysUser)authentication.getPrincipal();
        Set<SysRole> roles = userDetails.getSysRoles();
        //输出登录提示信息
        System.out.println("管理员 " + userDetails.getName() + " 登录");
        //System.out.println("IP :"+getIpAddress(request));

        super.onAuthenticationSuccess(request, response, authentication);
    }

    /*public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }*/
}
