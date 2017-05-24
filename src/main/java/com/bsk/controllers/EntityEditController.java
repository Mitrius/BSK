package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.TableInfoService;
import com.bsk.services.UserTableAccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

/**
 * Created by Mitrius on 17.04.17.
 */
@Controller
public class EntityEditController {
    @Autowired
    UserTableAccessInfoService userTableAccessInfoService;
    @Autowired
    TableInfoService tableInfoService;

    @RequestMapping(value = "/editEntity")
    public ModelAndView editEntity(@RequestParam String type, @RequestParam String id, @RequestParam String entityHeader) {
        ModelAndView modelAndView = new ModelAndView("editView");
        String entity = userTableAccessInfoService.getEntry(type, id).toString();
        List<String> entityList = new ArrayList<>(Arrays.asList(entity.split(";")));
        if (Objects.equals(type, "User")) {
            entityHeader = "username;password;enabled;clearanceLevel";
            entityList.add(1, "");
        }
        modelAndView.getModelMap().addAttribute("type", type);
        modelAndView.getModelMap().addAttribute("entityHeader", entityHeader.split(";"));
        modelAndView.getModelMap().addAttribute("entity", entityList);

        return modelAndView;
    }

    @RequestMapping(value = "/editEntity/Customer", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Customer customer,
                             @RequestParam(value = "key") String key) {
        userTableAccessInfoService.edit(customer, key);
        return "redirect:/getSpecificTable?tableName=Customers";
    }

    @RequestMapping(value = "/editEntity/Employee", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Employee employee,
                             @RequestParam(value = "key") String key) {
        userTableAccessInfoService.edit(employee, key);
        return "redirect:/getSpecificTable?tableName=Employees";
    }

    @RequestMapping(value = "/editEntity/Rental", method = RequestMethod.POST)
    public String editEntity(@RequestParam(name = "cost") Double cost,
                             @RequestParam(name = "rentalDate") @DateTimeFormat(pattern = "yy-MM-dd") Date rentalDate,
                             @RequestParam(name = "tillDate") @DateTimeFormat(pattern = "yy-MM-dd") Date tillDate,
                             @RequestParam(name = "transactionID") Integer transactId,
                             @RequestParam(name = "videoID") Integer videoID,
                             @RequestParam(value = "key") String key) {

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
            userTableAccessInfoService.edit(rental, key);
        }
        return "redirect:/getSpecificTable?tableName=Rentals";
    }

    @RequestMapping(value = "/editEntity/ShopTransaction", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute ShopTransaction st,
                             @RequestParam(value = "key") String key) {
        userTableAccessInfoService.edit(st, key);
        return "redirect:/getSpecificTable?tableName=ShopTransactions";
    }

    @RequestMapping(value = "/editEntity/TableClassLevel", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute TableClassLevel tcl,
                             @RequestParam(value = "key") String key) {
        userTableAccessInfoService.edit(tcl, key);
        return "redirect:/getSpecificTable?tableName=TableClassLevels";
    }

    @RequestMapping(value = "/editEntity/User", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute User user,
                             @RequestParam(value = "key") String key, Principal principal) {
        if ((user.getClearanceLevel() <= 3) && (user.getClearanceLevel() >= 0) &&
                (tableInfoService.isWritable(principal.getName(), "Users"))) {
            user.setRole("USER");
            userTableAccessInfoService.edit(user, key);
        }
        return "redirect:/getSpecificTable?tableName=Users";
    }

    @RequestMapping(value = "/editEntity/Video", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Video video,
                             @RequestParam(value = "key") String key) {
        userTableAccessInfoService.edit(video, key);
        return "redirect:/getSpecificTable?tableName=Videos";
    }
}
