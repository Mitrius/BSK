package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.RegisterService;
import com.bsk.services.TableInfoService;
import com.bsk.services.UserTableAccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

@Controller
public class EntityCreateController {
    @Autowired
    private UserTableAccessInfoService userTableAccessInfoService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private TableInfoService tableInfoService;

    @RequestMapping(value = "/createNewClass/Customer", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Customer cust, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Customers")) {
            userTableAccessInfoService.insertValue(cust);
        }
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/TableClassLevel", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute TableClassLevel tableClassLevel, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "TableClassLevels"))
            userTableAccessInfoService.insertValue(tableClassLevel);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/Employee", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Employee employee, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Employees"))
            userTableAccessInfoService.insertValue(employee);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/Rental", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "cost") Double cost,
                                  @RequestParam(name = "rentalDate") @DateTimeFormat(pattern = "dd.MM.yy") Date rentalDate,
                                  @RequestParam(name = "tillDate") @DateTimeFormat(pattern = "dd.MM.yy") Date tillDate,
                                  @RequestParam(name = "transactionID") Integer transactId,
                                  @RequestParam(name = "videoID") Integer videoID, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Videos")) {
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
        }
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/ShopTransaction", method = RequestMethod.POST)
    public String createNewEntity(@RequestParam(name = "employee") Integer employee,
                                  @RequestParam(name = "customer") Integer customer, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "ShopTransactions")) {
            ShopTransaction transaction = new ShopTransaction();
            Employee employee1 = (Employee) userTableAccessInfoService.getEntry("Employee", String.valueOf(employee));
            Customer customer1 = (Customer) userTableAccessInfoService.getEntry("Customer", String.valueOf(customer));
            if (employee1 != null && customer1 != null) {
                transaction.setId(null);
                transaction.setCustomer(customer1);
                transaction.setEmployee(employee1);

                userTableAccessInfoService.insertValue(transaction);
            }
        }
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/Video", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute Video object, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Videos"))
            userTableAccessInfoService.insertValue(object);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/createNewClass/User", method = RequestMethod.POST)
    public String createNewEntity(@ModelAttribute User user, Principal principal) {
        if ((user.getClearanceLevel() <= 3) && (user.getClearanceLevel() >= 0)
                && (tableInfoService.isWritable(principal.getName(), "Users"))) {
            registerService.registerUser(user);
        }
        return "redirect:/tableView";
    }
}
