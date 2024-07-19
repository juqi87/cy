package com.mzb.cy.controller.login;

import com.mzb.cy.base.BaseResponse;
import com.mzb.cy.base.BusinessException;
import com.mzb.cy.base.DataTableResponse;
import com.mzb.cy.common.CyConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {


    @GetMapping("/login")
    public String login() {
        log.info("进入登陆页面");
        

        return "login1";
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<Integer> doLogin(HttpServletRequest request, String user, String pwd) {
        log.info("登陆操作");
        BaseResponse<Integer> resp = new BaseResponse<>();
        if(StringUtils.isBlank(user)
                || StringUtils.isBlank(pwd)){
            resp.setCode("999")
                    .setMsg("账户或者密码为空");
            return resp;
        }

        try{
//            if(!StringUtils.equals(user, CyConstant.user)
//                    || !StringUtils.equals(pwd, CyConstant.pwd)){
//                log.info("账号密码错误, user==>{}, pwd==>{}", user, pwd);
//                throw new BusinessException("999", "账号或者密码错误");
//            }
            if(!StringUtils.equals(pwd, CyConstant.users.get(user))){
                log.info("账号密码错误, user==>{}, pwd==>{}", user, pwd);
                throw new BusinessException("999", "账号或者密码错误");
            }

            request.getSession().setAttribute("user", user);

            resp.setCode("000")
                    .setMsg("登陆成功")
                    .setData(1);
        }catch(BusinessException be){
            resp.setCode(be.getErrCode())
                    .setMsg(be.getErrDesc());
        }catch (Exception e){
            resp.setCode("999")
                    .setMsg("登陆失败");
        }

        log.info("登陆结果==>{}", resp);
        return resp;
    }

    @GetMapping("/logout")
    public String logout(ModelMap model, HttpSession session) {
        log.info("退出操作");
        session.invalidate();
        model.put("message", "You have been logged out successfully.");
        return "login";
    }

}
