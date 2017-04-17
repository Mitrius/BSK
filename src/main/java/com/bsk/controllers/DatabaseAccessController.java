package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.TableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {
    @Autowired
    private TableDataService tableDataService;

    @RequestMapping(value = "/createNewClass/Customer", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Customer cust) {
        cust.setId(null);
        tableDataService.insertValue(cust);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Employee", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Employee employee) {
        employee.setId(null);
        tableDataService.insertValue(employee);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Rental", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Rental object) {
        object.setId(null);
        tableDataService.insertValue(object);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute ShopTransaction object) {
        object.setId(null);
        tableDataService.insertValue(object);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Video object) {
        object.setId(null);
        tableDataService.insertValue(object);
        return "tableDataView";
    }

}
