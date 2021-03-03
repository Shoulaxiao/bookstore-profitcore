package com.shoulaxiao.controller.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 16:21
 * @Description TODO
 * @Version 1.0
 **/
public class WeiXinUtil {

    public static Cookie getCookies(HttpServletRequest request, String cookieName) {
       Cookie[] cookies=request.getCookies();
       if (cookies==null||cookieName==null||cookieName.equals("")){
           return null;
       }
       for (Cookie cookie :cookies){
           if (cookie.getName().equals(cookieName)){
               return cookie;
           }
       }
       return null;
    }
}
