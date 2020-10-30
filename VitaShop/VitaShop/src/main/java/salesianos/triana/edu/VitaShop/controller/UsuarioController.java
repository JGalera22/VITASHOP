package salesianos.triana.edu.VitaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    @GetMapping("/")
    public String miPerfil(){
        return "user";
    }

    @Autowired
    UsuarioServicio servicioUser;


    @GetMapping("/cambiarPass/{id}")
    public String cambiarPass(@PathVariable long id, Model model){

        Usuario usuario = servicioUser.findById(id);
        if (usuario != null){
            model.addAttribute("usuario" , usuario);
            return "cambiarPass";
        }else{
            return "redirect:/index";
        }


    }

    @PostMapping("/cambiarPass/submit")
    public String cambiarPassSubmit(@ModelAttribute("usuario") Usuario usuario){
        servicioUser.edit(usuario);
        return "cambiarPass";
    }


}
