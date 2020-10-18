package salesianos.triana.edu.VitaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomeController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
