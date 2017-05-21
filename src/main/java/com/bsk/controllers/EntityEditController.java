package com.bsk.controllers;

import com.bsk.entities.*;
import com.bsk.services.TableInfoService;
import com.bsk.services.UserTableAccessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

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

        modelAndView.getModelMap().addAttribute("type", type);
        modelAndView.getModelMap().addAttribute("entityHeader", entityHeader.split(","));
        modelAndView.getModelMap().addAttribute("entity", entity.split(","));


        return modelAndView;
    }

    @RequestMapping(value = "/editEntity/Customer", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Customer customer,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Customers"))
            userTableAccessInfoService.editCustomer(customer, key);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/Employee", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Employee employee,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Employees"))
            userTableAccessInfoService.editEmployee(employee, key);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/Rental", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Rental rental,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Rentals"))
            userTableAccessInfoService.editRental(rental, key);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/ShopTransaction", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute ShopTransaction st,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "ShopTransactions"))
            userTableAccessInfoService.editShopTransaction(st, key);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/TableClassLevel", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute TableClassLevel tcl,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "TableClassLevels"))
            userTableAccessInfoService.editTableClassLevel(tcl, key);
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/User", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute User user,
                             @RequestParam(value = "key") String key, Principal principal) {
        if ((user.getClearanceLevel() <= 3) && (user.getClearanceLevel() >= 0) &&
                (tableInfoService.isWritable(principal.getName(), "Customers"))) {
            userTableAccessInfoService.editUser(user, key);
        }
        return "redirect:/tableView";
    }

    @RequestMapping(value = "/editEntity/Video", method = RequestMethod.POST)
    public String editEntity(@ModelAttribute Video video,
                             @RequestParam(value = "key") String key, Principal principal) {
        if (tableInfoService.isWritable(principal.getName(), "Videos"))
            userTableAccessInfoService.editVideo(video, key);
        return "redirect:/tableView";
    }
}
