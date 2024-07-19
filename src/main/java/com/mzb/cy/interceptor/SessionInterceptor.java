package com.mzb.cy.interceptor;

import com.mzb.cy.common.CyConstant;
import com.mzb.cy.utils.IPUtils;
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
        log.info("request ip==>{}", IPUtils.getClientIP(request));
        log.info("SessionInterceptor preHandle  url==>{}", url);
        if (StringUtils.equals(url, "/login") || StringUtils.equals(url, "/logout")) {
            return true;
        }

        if(request.getSession().getAttribute("user") != null){
            log.info("已登陆, user=={}", request.getSession().getAttribute("user"));
            return true;
        }
        log.info("未登陆");
        response.sendRedirect("/login");
        return false;
    }



}
