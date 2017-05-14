package com.bsk.controllers.ViewControllers;

import com.bsk.entities.EntityBSKClass;
import com.bsk.services.TableInfoService;
import com.bsk.services.UserTableAccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DataViewController {

    @Autowired
    private TableInfoService tableInfoService;
    @Autowired
    private UserTableAccessInfoService userTableAccessInfoService;

    @RequestMapping(value = "/getSpecificTable", method = RequestMethod.GET)
    public ModelAndView getSpecificTable(@RequestParam String tableName, Principal principal) throws ReflectiveOperationException {
        String className = tableName.substring(0, tableName.length() - 1);

        ModelAndView modelAndView = new ModelAndView("tableDataView");
        List<Object> entities = userTableAccessInfoService.getSpecificTable(className);

        Class<?> cls = Class.forName("com.bsk.entities." + className);
        Object ret = cls.newInstance();
        String classHeader = ((EntityBSKClass) ret).getHeader();

        if (tableInfoService.isReadable(principal.getName(), tableName))//if table is readable
        {
            List<String> entitiesString = entities.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            modelAndView.getModelMap().addAttribute("table", entitiesString);
        }
        modelAndView.getModelMap().addAttribute("type", className);
        modelAndView.getModelMap().addAttribute("entityHeader", classHeader);

        return modelAndView;
    }

    @RequestMapping(value = "/getTableNames", method = RequestMethod.GET)
    public ModelAndView getTableNames() {
        List<String> tables = tableInfoService.listAllTables();
        ModelAndView modelAndView = new ModelAndView("tableDataView");
        modelAndView.getModelMap().addAttribute("possibleTables", tables);
        return modelAndView;
    }
}
