package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"/","/welcome"})
    public String welcomePage(){

        return "welcomepage/welcome-page";

    }

}
