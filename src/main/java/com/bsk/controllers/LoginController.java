package com.bsk.controllers;

import com.bsk.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Mitrius on 12.03.17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    //Kontrola logowania
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute("user") User userProc, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("tableView");
        if (validateUser(userProc)) {
            modelAndView.getModelMap().addAttribute("user", userProc);
            session.setAttribute("username", userProc.getUserLogin());
        }
        return modelAndView;
    }

    //Metoda łączy się z bazą danych i sprawdza obecność w niej usera o podanych danych
    private Boolean validateUser(User userProc) {
        //TODO kontakt z bazą danych i walidacja użytkownika
        return true;
    }

    @RequestMapping(value = "/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
