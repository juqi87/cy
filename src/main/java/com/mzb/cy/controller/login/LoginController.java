package com.mzb.cy.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginController {


    @GetMapping("/login")
    public String login() {
        log.info("进入登陆页面");
        

        return "login";
    }

//    @PostMapping("/doLogin")
//    public String doLogin() {
//        log.info("登陆操作");
//
//
//        return "redirect:/cyOrdLogList";
//    }

    @GetMapping("/logout")
    public String logout(ModelMap model) {
        log.info("退出操作");

        model.put("message", "You have been logged out successfully.");

        return "login";
    }

}
