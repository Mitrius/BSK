package com.bsk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mitrius on 12.03.17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"})
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "login";
    }

}
