package salesianos.triana.edu.VitaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    UsuarioServicio usuarioServicio;
    @GetMapping("/registro")
    public String registro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    /*@GetMapping("/Registro")
    public ModelAndView createUser(@Valid Usuario user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("usuario", user);
        model.setViewName(result.hasErrors() ? "userForm" : "userReady");
        return model;
    }*/

    @PostMapping("/registro/submit")
    public String registroUsuarioSubmit(@Valid @ModelAttribute("usuario") Usuario usuario,
                                        BindingResult bindingResult, BCryptPasswordEncoder passwordEncoder){

        if (bindingResult.hasErrors()){
            return "registro";
        }else {
            usuarioServicio.registrar(usuario, passwordEncoder);
            return "redirect:/login";
        }
    }
}
