package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.TableDataService;
import com.bsk.services.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {
    @Autowired
    private TableInfoService tableInfoService;
    @Autowired
    private TableDataService tableDataService;

    @RequestMapping(value = "/getSpecificTable", method = RequestMethod.GET)
    public ModelAndView getSpecificTable(@RequestParam String tableName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = tableName.substring(0, tableName.length() - 1);

        Class<?> cls = Class.forName("com.bsk.entities." + className);
        String classHeader = (String) cls.getMethod("getHeader").invoke(null, (Object[]) null);


        ModelAndView modelAndView = new ModelAndView("tableDataView");
        List<String> entities = tableDataService
                .getSpecificTable(className)
                .stream()
                .map(c -> c.toString())
                .map(c -> c.replaceAll("[^a-zA-Z0-9,]", ""))
                .collect(Collectors.toList());
        modelAndView.getModelMap().addAttribute("table", entities);
        modelAndView.getModelMap().addAttribute("type", className);
        modelAndView.getModelMap().addAttribute("entityHeader", classHeader);
        return modelAndView;
    }
    @RequestMapping(value = "/getPossibleTables")
    public ModelAndView getPossibleTables(Principal principal) {
        List<String> possibleTables = tableInfoService.getUserPossibleTables(principal.getName());
        ModelAndView modelAndView = new ModelAndView("tableDataView");
        modelAndView.getModelMap().addAttribute("possibleTables", possibleTables);
        return modelAndView;
    }

    @RequestMapping(value = "/createNewClass/Customer", method = RequestMethod.POST)
    public void createNewEntity(Customer object) {
        tableDataService.insertValue(object);
    }

    @RequestMapping(value = "/createNewClass/Employee", method = RequestMethod.POST)
    public void createNewEntity(Employee object) {
        tableDataService.insertValue(object);
    }

    @RequestMapping(value = "/createNewClass/Rental", method = RequestMethod.POST)
    public void createNewEntity(Rental object) {
        tableDataService.insertValue(object);
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public void createNewEntity(ShopTransaction object) {
        tableDataService.insertValue(object);
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public void createNewEntity(Video object) {
        tableDataService.insertValue(object);
    }



}
