package com.mzb.cy.config;

import com.mzb.cy.interceptor.LicenseInterceptor;
import com.mzb.cy.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LicenseInterceptor licenseInterceptor;

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(licenseInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/generateLicense");

        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/visitIndex")
                .excludePathPatterns("/visit")
                .excludePathPatterns("/login", "/adminlte/**","/static/**", "/css/**", "/js/**", "/images/**");;
    }

}
