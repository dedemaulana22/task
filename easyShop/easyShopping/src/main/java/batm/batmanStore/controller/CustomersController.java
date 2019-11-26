/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.controller;

import batm.batmanStore.Model.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import batm.batmanStore.Services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dedem
 */
@Controller
public class CustomersController {
    private CustomerService customerService;

    
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    @RequestMapping("/Sales/Customer")
    public String Customer(Model model){
        model.addAttribute("customers", customerService.Listcustomer());
        return "Sales/Customer";
    }
    
    @RequestMapping(value = "/Sales/Customer/Create", method = RequestMethod.GET)
        public String tampilkanForm(Model model){
            model.addAttribute("customers", new Customers());
            return "Sales/formCustomer";
        }
        
    @RequestMapping(value = "/Sales/Customer/Create", method = RequestMethod.POST)
        public String simpanDataCustomer(Model model, Customers customers){
            model.addAttribute("customers", customerService.saveOrUpdate(customers));
            return "redirect:/Sales/Customer";
        }
    
    @RequestMapping(value = "/Sales/Customer/Edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("customers", customerService.getIdCustomer(id));
        return "Sales/formCustomer";
    }
    
    @RequestMapping(value = "/Sales/Customer/Delete/{id}")
    public String delete(@PathVariable int id){
        customerService.deleteId(id);
        return "redirect:/Sales/Customer";
    }
    
}
