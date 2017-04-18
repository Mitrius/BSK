package com.bsk.controllers.ViewControllers;

import com.bsk.entities.EntityBSKClass;
import com.bsk.services.TableDataService;
import com.bsk.services.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 17.04.17.
 */
@Controller
public class DataViewController {

    @Autowired
    private TableInfoService tableInfoService;
    @Autowired
    private TableDataService tableDataService;

    @RequestMapping(value = "/getSpecificTable", method = RequestMethod.GET)
    public ModelAndView getSpecificTable(@RequestParam String tableName) throws ReflectiveOperationException {
        String className = tableName.substring(0, tableName.length() - 1);

        ModelAndView modelAndView = new ModelAndView("tableDataView");
        List<Object> entities = tableDataService.getSpecificTable(className);

        Class<?> cls = Class.forName("com.bsk.entities." + className);
        Object ret = cls.newInstance();
        String classHeader = ((EntityBSKClass) ret).getHeader();

        List<String> entitiesString = entities.stream()
                .map(c -> c.toString())
                .map(c -> c.replaceAll("[^a-zA-Z0-9,.]", ""))
                .collect(Collectors.toList());
        modelAndView.getModelMap().addAttribute("table", entitiesString);
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
}
