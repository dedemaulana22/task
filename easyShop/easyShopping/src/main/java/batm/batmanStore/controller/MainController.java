/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author USER
 */
@Controller
public class MainController {
    
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String user(){
        return ("Home");
    }
    
    @RequestMapping(value = "/adminhome", method = RequestMethod.GET)
    public String Admin() {
        return ("adminhome");
    } 

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
}
