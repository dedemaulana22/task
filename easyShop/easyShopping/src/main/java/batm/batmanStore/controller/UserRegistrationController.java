/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.controller;

import batm.batmanStore.Model.User;
import batm.batmanStore.reg.UserRegistration;
import batm.batmanStore.Services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    @Autowired
    private UserService userService;
    
    @ModelAttribute("user")
    public UserRegistration userRegistration(){
        return new UserRegistration();
    }
    
    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }
    
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistration userReg,
            BindingResult result){
        User existing = userService.findByEmail(userReg.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(userReg);
        return "redirect:/registration?success";
    }
}
