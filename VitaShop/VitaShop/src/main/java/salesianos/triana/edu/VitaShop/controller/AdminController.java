package salesianos.triana.edu.VitaShop.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "administrador/index";
    }

    @GetMapping("/info")
    public String info(@AuthenticationPrincipal Usuario usuario, Model model) {
        model.addAttribute("nombre", usuario.getNombre() + " " + usuario.getApellidos());
        return "administrador/info";
    }

}
