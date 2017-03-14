package com.bsk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Password;

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
    //TODO hasło
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("userLogin") String userLogin,
                                  @RequestParam("userPassword") String userPassword,
                                  HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("tableView");
        if (validateUser(userLogin, userPassword)) {
            modelAndView.getModelMap().addAttribute("user", userLogin);
            session.setAttribute("username", userLogin);
        }
        return modelAndView;
    }

    //Metoda łączy się z bazą danych i sprawdza obecność w niej usera o podanych danych
    private Boolean validateUser(String username, String password) {
        //TODO kontakt z bazą danych i walidacja użytkownika
        return true;
    }

    @RequestMapping(value = "/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
