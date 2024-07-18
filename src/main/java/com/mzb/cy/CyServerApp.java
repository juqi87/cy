package com.mzb.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.mzb.cy.dao")
public class CyServerApp {

    public static void main(String[] args) {
        SpringApplication.run(CyServerApp.class, args);
    }

}
