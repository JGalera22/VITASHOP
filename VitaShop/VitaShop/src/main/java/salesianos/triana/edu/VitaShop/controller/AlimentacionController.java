package salesianos.triana.edu.VitaShop.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AlimentacionController {

    @GetMapping("/alimentacion")
    public String alimentacion() {
        return "alimentacion";
    }



}