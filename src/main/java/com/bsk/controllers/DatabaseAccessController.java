package com.bsk.controllers;

import com.bsk.entities.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @RequestMapping(value = "/getPossibleTables", method = RequestMethod.GET)
    @ResponseBody
    //Zwróć dostępne tablice dla użytkownika
    public String getPossibleTables(User user) {
        String[][] table = {{"coŚ a", "coś b", "coś c", "coś d"}, {"a", "b", "c", "d"}, {"b", "c", "d", "a"}};
        List<String[][]> tables = new ArrayList<String[][]>();
        tables.add(table);
        Gson gson = new Gson();
        return gson.toJson(tables);
    }

}
