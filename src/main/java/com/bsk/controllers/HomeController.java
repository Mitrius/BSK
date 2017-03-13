package com.bsk.controllers;

import com.bsk.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mitrius on 12.03.17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("tableView");
        modelAndView.getModelMap().addAttribute("user", user);
        return modelAndView;
    }
}
