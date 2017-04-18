package com.bsk.controllers;

import com.bsk.services.TableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mitrius on 17.04.17.
 */
@Controller
public class EntityEditController {
    @Autowired
    TableDataService tableDataService;

    @RequestMapping(value = "/editEntity")
    public ModelAndView editEntity(@RequestParam String type, @RequestParam Object id, @RequestParam String entityHeader) {
        ModelAndView modelAndView = new ModelAndView("editView");
        String entity = tableDataService.getVerySpecificTable(type, id).toString();

        modelAndView.getModelMap().addAttribute("type", type);
        modelAndView.getModelMap().addAttribute("entityHeader", entityHeader.split(","));
        modelAndView.getModelMap().addAttribute("entity", entity.split(","));


        return modelAndView;
    }
}
