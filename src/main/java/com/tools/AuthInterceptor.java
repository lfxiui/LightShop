package com.tools;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by AgZou on 2017/6/1.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      boolean flag=true;
       if(request.getSession().getAttribute("userId")==null){
           response.sendRedirect("/login");
           flag=false;
       }
       return flag;
    }
}
