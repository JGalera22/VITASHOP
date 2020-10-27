package salesianos.triana.edu.VitaShop.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DeportesController {

    @GetMapping("/deportes")
    public String deportes() {
        return "deportes";
    }

}
