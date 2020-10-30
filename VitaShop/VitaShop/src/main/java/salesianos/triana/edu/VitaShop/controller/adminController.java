package salesianos.triana.edu.VitaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {
@RequestMapping("/admin")
    @GetMapping("/")
    public String welcome(){
        return "redirect:/index/";
    }

}
