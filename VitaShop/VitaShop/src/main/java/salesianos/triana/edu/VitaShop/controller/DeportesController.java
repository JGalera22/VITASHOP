package salesianos.triana.edu.VitaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeportesController {

    @GetMapping("/deportes")
    public String deportes() {
        return "deportes";
    }

}
