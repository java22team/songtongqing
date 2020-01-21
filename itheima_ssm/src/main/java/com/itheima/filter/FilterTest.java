package com.itheima.filter;


import com.itheima.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
//拦截是否登录
public class FilterTest extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        ServletRequest request= (ServletRequest) _request;
//        ServletResponse response= _response;
        request.setCharacterEncoding("UTF-8");

        User user = (User) request.getSession().getAttribute("user");

        if (user!=null){
            //登录了
        return true;
        }else{

//            没有登录

            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return  false;


        }


    }
}
