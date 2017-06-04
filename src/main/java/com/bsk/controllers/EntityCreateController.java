package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.RegisterService;
import com.bsk.services.UserTableAccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EntityCreateController {
    @Autowired
    private UserTableAccessInfoService userTableAccessInfoService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/createNewClass/Customer", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Customer cust) {
            userTableAccessInfoService.insertValue(cust);
        return "redirect:/getSpecificTable?tableName=Customers";
    }

    @RequestMapping(value = "/createNewClass/TableClassLevel", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute TableClassLevel tableClassLevel) {
        userTableAccessInfoService.insertValue(tableClassLevel);
        return "redirect:/getSpecificTable?tableName=TableClassLevels";
    }

    @RequestMapping(value = "/createNewClass/Employee", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Employee employee) {
        userTableAccessInfoService.insertValue(employee);
        return "redirect:/getSpecificTable?tableName=Employees";
    }

    @RequestMapping(value = "/createNewClass/Rental", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "cost") Double cost,
                                  @RequestParam(name = "rentalDate") @DateTimeFormat(pattern = "yy-MM-dd") Date rentalDate,
                                  @RequestParam(name = "tillDate") @DateTimeFormat(pattern = "yy-MM-dd") Date tillDate,
                                  @RequestParam(name = "transactionID") Integer transactId,
                                  @RequestParam(name = "videoID") Integer videoID) {
            Video video = (Video) userTableAccessInfoService.getEntry("Video", String.valueOf(videoID));
            ShopTransaction transaction = (ShopTransaction) userTableAccessInfoService.getEntry("ShopTransaction", String.valueOf(transactId));
            if (video != null && transaction != null) {
                Rental rental = new Rental();
                rental.setCost(cost);
                rental.setId(null);
                rental.setRentalDate(new java.sql.Date(rentalDate.getTime()));
                rental.setTillDate(new java.sql.Date(tillDate.getTime()));
                rental.setVideo(video);
                rental.setTransaction(transaction);

                userTableAccessInfoService.insertValue(rental);
            }
        return "redirect:/getSpecificTable?tableName=Rentals";
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "employee") Integer employee,
                                  @RequestParam(name = "customer") Integer customer) {
            ShopTransaction transaction = new ShopTransaction();
            Employee employee1 = (Employee) userTableAccessInfoService.getEntry("Employee", String.valueOf(employee));
            Customer customer1 = (Customer) userTableAccessInfoService.getEntry("Customer", String.valueOf(customer));
            if (employee1 != null && customer1 != null) {
                transaction.setId(null);
                transaction.setCustomer(customer1);
                transaction.setEmployee(employee1);
                userTableAccessInfoService.insertValue(transaction);
            }
        return "redirect:/getSpecificTable?tableName=ShopTransactions";
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Video object) {
        userTableAccessInfoService.insertValue(object);
        return "redirect:/getSpecificTable?tableName=Videos";
    }

    @RequestMapping(value = "/createUser")
    public String registerUser() {
        return "/registerView";
    }
    @RequestMapping(value = "/createNewClass/User", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute User user) {
        registerService.registerUser(user);
        return "redirect:/getSpecificTable?tableName=Users";
    }
}
