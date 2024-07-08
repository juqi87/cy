package com.mzb.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CyServerApp {

    public static void main(String[] args) {
        SpringApplication.run(CyServerApp.class);
    }

}
