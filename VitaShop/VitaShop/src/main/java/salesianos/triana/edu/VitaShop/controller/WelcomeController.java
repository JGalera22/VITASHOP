package salesianos.triana.edu.VitaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PathVariable;
import salesianos.triana.edu.VitaShop.servicios.ProductoServicio;


import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    ProductoServicio productoServicio;

    /*@GetMapping("/index")
    public String info(@AuthenticationPrincipal Usuario usuario, Model model) {
        model.addAttribute("nombre", usuario.getNombre() + " " + usuario.getApellidos());
        return "index";
    }*/

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Usuario usuario) {

        if (usuario != null)
            logger.info(usuario.toString());
        else
            logger.info("Usuario nulo");

        return "index";
    }

    @ModelAttribute("productos")
    public List<Producto> productosNoVendidos(){
        return productoServicio.productosSinVender();
    }

    @GetMapping( "/index")
    public String index(Model model, @RequestParam(name="q", required = false) String query){
        if (query!= null)
            model.addAttribute("productos", productoServicio.buscar(query));
        return "index";
    }

    @GetMapping("/producto/{id}")
    public String showProdcutModel(Model model, @PathVariable Long id){
        Producto result = productoServicio.findById(id);
        if (result != null){
            model.addAttribute("producto" , result);
        }
        return "redirect:/index";
    }

}
