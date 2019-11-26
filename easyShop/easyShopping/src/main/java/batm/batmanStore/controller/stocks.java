
package batm.batmanStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class stocks {
    @RequestMapping("production/stocks")
    public String stocks(){
        return ("production/stocks");
    }
}
