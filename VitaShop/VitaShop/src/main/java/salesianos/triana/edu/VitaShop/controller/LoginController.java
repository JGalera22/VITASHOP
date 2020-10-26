package salesianos.triana.edu.VitaShop.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping("/")
    public String welcome(){
        return "redirect:/index/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
