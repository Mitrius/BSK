package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.TableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {
    @Autowired
    private TableDataService tableDataService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEntity(@RequestParam(value="key", required=true) String key,
                               @RequestParam(value="tableName", required=true) String tableName){
        tableDataService.deleteEntity(key, tableName);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/Video", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Video video,
                             @RequestParam(value="key") String key) {
        tableDataService.editVideo(video, Integer.parseInt(key));
        return "tableDataView";
    }

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
    public String createNewEntity(@RequestParam(name = "cost") Double cost,
                                  @RequestParam(name = "rentalDate") @DateTimeFormat(pattern = "dd.MM.yy") Date rentalDate,
                                  @RequestParam(name = "tillDate") @DateTimeFormat(pattern = "dd.MM.yy") Date tillDate,
                                  @RequestParam(name = "transactionID") Integer transactId,
                                  @RequestParam(name = "videoID") Integer videoID) {
        Video video = (Video) tableDataService.getEntry("Video", String.valueOf(videoID));
        ShopTransaction transaction = (ShopTransaction) tableDataService.getEntry("ShopTransaction", String.valueOf(transactId));
        if (video != null && transaction != null) {
            Rental rental = new Rental();
            rental.setCost(cost);
            rental.setRentalDate(new java.sql.Date(rentalDate.getTime()));
            rental.setTillDate(new java.sql.Date(tillDate.getTime()));
            rental.setVideo(video);
            rental.setTransaction(transaction);

            tableDataService.insertValue(rental);
        }
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "employee") Integer employee,
                                  @RequestParam(name = "customer") Integer customer) {
        ShopTransaction transaction = new ShopTransaction();
        Employee employee1 = (Employee) tableDataService.getEntry("Employee", String.valueOf(employee));
        Customer customer1 = (Customer) tableDataService.getEntry("Customer", String.valueOf(customer));
        if (employee1 != null && customer1 != null) {

            transaction.setCustomer(customer1);
            transaction.setEmployee(employee1);

            tableDataService.insertValue(transaction);
        }
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Video object) {
        object.setId(null);
        tableDataService.insertValue(object);
        return "tableDataView";
    }

}
