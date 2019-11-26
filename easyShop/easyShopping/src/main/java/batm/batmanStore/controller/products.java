
package batm.batmanStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class products {
    @RequestMapping("production/products")
    public String products(){
        return ("production/products");
    }
}
