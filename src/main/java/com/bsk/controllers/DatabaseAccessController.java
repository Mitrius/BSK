package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.UserTableAccessInfoService;
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
    private UserTableAccessInfoService userTableAccessInfoService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEntity(@RequestParam(value="key", required=true) String key,
                               @RequestParam(value="tableName", required=true) String tableName){
        userTableAccessInfoService.deleteEntity(key, tableName);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/Customer", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Customer customer,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editCustomer(customer, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/Employee", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Employee employee,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editEmployee(employee, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/Rental", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Rental rental,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editRental(rental, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/ShopTransaction", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute ShopTransaction st,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editShopTransaction(st, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/TableClassLevel", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute TableClassLevel tcl,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editTableClassLevel(tcl, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/User", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute User user,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editUser(user, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/editEntity/Video", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Video video,
                             @RequestParam(value="key") String key) {
        userTableAccessInfoService.editVideo(video, key);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Customer", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Customer cust) {
        cust.setId(null);
        userTableAccessInfoService.insertValue(cust);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/TableClassLevel", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute TableClassLevel tableClassLevel) {
        userTableAccessInfoService.insertValue(tableClassLevel);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Employee", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Employee employee) {
        employee.setId(null);
        userTableAccessInfoService.insertValue(employee);
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Rental", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "cost") Double cost,
                                  @RequestParam(name = "rentalDate") @DateTimeFormat(pattern = "dd.MM.yy") Date rentalDate,
                                  @RequestParam(name = "tillDate") @DateTimeFormat(pattern = "dd.MM.yy") Date tillDate,
                                  @RequestParam(name = "transactionID") Integer transactId,
                                  @RequestParam(name = "videoID") Integer videoID) {
        Video video = (Video) userTableAccessInfoService.getEntry("Video", String.valueOf(videoID));
        ShopTransaction transaction = (ShopTransaction) userTableAccessInfoService.getEntry("ShopTransaction", String.valueOf(transactId));
        if (video != null && transaction != null) {
            Rental rental = new Rental();
            rental.setCost(cost);
            rental.setRentalDate(new java.sql.Date(rentalDate.getTime()));
            rental.setTillDate(new java.sql.Date(tillDate.getTime()));
            rental.setVideo(video);
            rental.setTransaction(transaction);

            userTableAccessInfoService.insertValue(rental);
        }
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "employee") Integer employee,
                                  @RequestParam(name = "customer") Integer customer) {
        ShopTransaction transaction = new ShopTransaction();
        Employee employee1 = (Employee) userTableAccessInfoService.getEntry("Employee", String.valueOf(employee));
        Customer customer1 = (Customer) userTableAccessInfoService.getEntry("Customer", String.valueOf(customer));
        if (employee1 != null && customer1 != null) {

            transaction.setCustomer(customer1);
            transaction.setEmployee(employee1);

            userTableAccessInfoService.insertValue(transaction);
        }
        return "tableDataView";
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Video object) {
        object.setId(null);
        userTableAccessInfoService.insertValue(object);
        return "tableDataView";
    }

}
