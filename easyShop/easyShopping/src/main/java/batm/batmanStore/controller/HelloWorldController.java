/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batm.batmanStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author dedem
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public String home(){
        return "Hello";
    }
}
