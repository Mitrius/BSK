package com.bsk.controllers;

import com.bsk.entities.User;
import com.bsk.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krystian on 14.04.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = {"/register"})
    public String index() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value="username", required=true) String username,
                         @RequestParam(value="password", required=true) String password) {
        //TODO
        User kek = registerService.getByID(Integer.parseInt(username));
        if (kek == null){
            registerService.registerUser(Integer.parseInt(username), password);
        }
        return "redirect:/tableView";
    }
}
