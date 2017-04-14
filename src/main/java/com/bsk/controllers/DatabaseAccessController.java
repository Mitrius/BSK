package com.bsk.controllers;

import com.bsk.entities.Video;
import com.bsk.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 13.03.17.
 */
@Controller
public class DatabaseAccessController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/getPossibleTables")
    //Zwróć dostępne tablice dla użytkownika
    public ModelAndView getPossibleTables(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("tableDataView");
        modelAndView.getModelMap().addAttribute("videoListString",
                videoService.getAllVideos().stream().map(Video::toString).collect(Collectors.toList()));
        return modelAndView;
    }

}
