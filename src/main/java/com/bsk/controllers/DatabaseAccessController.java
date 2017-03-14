package com.bsk.controllers;

import com.bsk.entities.Customer;
import com.bsk.entities.Video;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @RequestMapping(value = "/getPossibleTables")
    //Zwróć dostępne tablice dla użytkownika
    public ModelAndView getPossibleTables(HttpSession session) {
        List<Customer> custList = new ArrayList<>();
        custList.add(new Customer(1, "Stefan", "S"));
        custList.add(new Customer(2, "Anita", "Z"));

        List<Video> videoList = new ArrayList<>();
        videoList.add(new Video(1, "Forrest Gump", 12.50, "dostępne"));
        videoList.add(new Video(1, "kruk", 12.50, "dostępne"));

        List<List<String>> tables = new ArrayList<>();

        tables.add(custList.stream().map(Object::toString).collect(Collectors.toList()));
        tables.add(videoList.stream().map(Object::toString).collect(Collectors.toList()));


        ModelAndView modelAndView = new ModelAndView("tableView");
        modelAndView.getModelMap().addAttribute("tables", tables);

        return modelAndView;
    }

}
