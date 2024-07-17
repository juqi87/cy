package com.mzb.cy.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LicenseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String license = request.getHeader("License-Key");
//        if (license == null || !LicenseManager.validateLicense(license)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "License is invalid or expired");
//            return false;
//        }
//        log.info("License is valid: {}", license);
        return true;
    }

}
