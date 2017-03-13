package com.bsk.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @RequestMapping(value = "/getPossibleTables")
    @ResponseBody
    public String getPossibleTables() {
        Gson gson = new Gson();
        List<String> tables = new ArrayList<String>();
        return gson.toJson(tables);
    }
}
