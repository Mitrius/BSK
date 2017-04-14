package com.bsk.controllers;

import com.bsk.entities.Video;
import com.bsk.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
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
    public
    @ResponseBody
    List<String> getPossibleTables(HttpSession session) {
        return videoService.getAllVideos().stream().map(Video::toString).collect(Collectors.toList());
    }

}
