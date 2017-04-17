package com.bsk.controllers;

import com.bsk.services.TableInfoService;
import com.bsk.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TableInfoService tableInfoService;

    @RequestMapping(value = "/getSpecificTable")
    public ModelAndView getSpecificTable(@RequestParam String tableName) {
        ModelAndView modelAndView = new ModelAndView("tableDataView");

        return modelAndView;
    }
    @RequestMapping(value = "/getPossibleTables")
    //Zwróć dostępne tablice dla użytkownika
    public ModelAndView getPossibleTables(Principal principal) {
        //See what he can do
        List<String> possibleTables = tableInfoService.getUserPossibleTables(principal.getName());
        ModelAndView modelAndView = new ModelAndView("tableDataView");

        //Pokazemy mu labelele
        modelAndView.getModelMap().addAttribute("possibleTables", possibleTables);

        return modelAndView;
    }

}
