package com.bsk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mitrius on 08.04.17.
 */
@Controller
public class AccessModificationController {
    @RequestMapping("changeUserClearance")
    public String changeUserClearance() {
        return "login";
    }
}
