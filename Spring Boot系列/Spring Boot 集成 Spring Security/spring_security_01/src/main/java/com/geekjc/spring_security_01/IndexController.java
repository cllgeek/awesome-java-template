package com.geekjc.spring_security_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ll
 * @date 2020年02月07日 1:09 PM
 *
 * 初次体验Spring Security
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello World ~";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "欢迎来到主页 ~";
    }

}
