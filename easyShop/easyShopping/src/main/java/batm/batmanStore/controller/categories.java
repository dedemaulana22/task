
package batm.batmanStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class categories {
    @RequestMapping("production/categories")
    public String categories(){
        return ("production/categories");
    }
}
