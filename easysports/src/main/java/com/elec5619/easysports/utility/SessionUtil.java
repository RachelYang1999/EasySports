package com.elec5619.easysports.utility;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        return request;

    }

    public static LoginUser getCurrentUser() {
        HttpServletRequest request = getHttpServletRequest();
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            return (LoginUser) user;
        }
        return null;
    }
    public static String getcurplayground(){
        HttpServletRequest request = getHttpServletRequest();
        Object playground =request.getSession().getAttribute("playground");
        if (playground != null) {
            return (String) playground;
        }
        return null;
    }

}
