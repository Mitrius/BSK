package com.bsk.controllers;

import com.bsk.services.TableDataService;
import com.bsk.services.TableInfoService;
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
    private TableInfoService tableInfoService;
    @Autowired
    private TableDataService tableDataService;

    @RequestMapping(value = "/getSpecificTable")
    public ModelAndView getSpecificTable(@RequestParam String tableName) {
        ModelAndView modelAndView = new ModelAndView("tableDataView");
        List<String> tableContent = tableDataService.getSpecificTable(tableName);
        modelAndView.getModelMap().addAttribute("table", tableContent);
        return modelAndView;
    }
    @RequestMapping(value = "/getPossibleTables")
    //Zwróć dostępne tablice dla użytkownika
    public ModelAndView getPossibleTables(Principal principal) {
        //See what he can do
        List<String> possibleTables = tableInfoService.getUserPossibleTables(principal.getName());
        ModelAndView modelAndView = new ModelAndView("tableDataView");


        //Pokazemy mu labele
        modelAndView.getModelMap().addAttribute("possibleTables", possibleTables);

        return modelAndView;
    }

}
