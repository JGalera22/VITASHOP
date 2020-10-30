package salesianos.triana.edu.VitaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.ProductoServicio;

@Controller
public class DeportesController {

    private Usuario usuario;

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/deportes")
    public String deportes(Model model) {
        model.addAttribute("productos", productoServicio.buscarPorCategoria("deportes"));


        return "deportes";
    }


}
