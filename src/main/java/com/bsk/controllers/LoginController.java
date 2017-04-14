package com.bsk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mitrius on 12.03.17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"})
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/tableView")
    public ModelAndView showTableDataView() {
        return new ModelAndView("tableDataView");
    }
}
