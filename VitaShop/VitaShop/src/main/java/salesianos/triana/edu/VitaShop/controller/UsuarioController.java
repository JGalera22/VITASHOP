package salesianos.triana.edu.VitaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

import javax.validation.Valid;

@Controller
public class UsuarioController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/registro")
    public String registro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }


/*
@RequestMapping("/formulario")
public class UsuarioController {

    @RequestMapping("/userForm")
    public String showUserForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "userForm";
    }

    @RequestMapping("/create")
    public ModelAndView createUser(@Valid Usuario user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("usuario", user);
        model.setViewName(result.hasErrors() ? "userForm" : "userReady");
        return model;
    }
*/
}
