package com.bsk.controllers;

import com.bsk.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @RequestMapping(value = "/getPossibleTables")
    //Zwróć dostępne tablice dla użytkownika
    public ModelAndView getPossibleTables(User user) {
        String[][] table = {{"coŚ a", "coś b", "coś c", "coś d"}, {"a", "b", "c", "d"}, {"b", "c", "d", "a"}};
        List<String[][]> tables = new ArrayList<String[][]>();
        tables.add(table);
        ModelAndView modelAndView = new ModelAndView("tableView");
        modelAndView.getModelMap().addAttribute("tables", tables);
        return modelAndView;
    }

}
