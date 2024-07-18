package com.mzb.cy.interceptor;

import com.mzb.cy.common.CyConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求地址，如果为login或者为logout则直接返回true
        String url = request.getRequestURI();
        log.info("SessionInterceptor preHandle  url==>{}", url);
        if (StringUtils.equals(url, "/login") || StringUtils.equals(url, "/logout")) {
            return true;
        }

        if(StringUtils.equals(request.getSession().getAttribute("user")+"", CyConstant.user)){
            return true;
        }
        log.info("未登陆");
        response.sendRedirect("/login");
        return false;
    }
}
