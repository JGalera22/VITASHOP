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
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.ProductoServicio;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

import javax.validation.Valid;

@Controller
public class AlimentacionController {

    private Usuario usuario;

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/alimentacion")
    public String alimentacion(Model model) {
        model.addAttribute("productos", productoServicio.buscarPorCategoria("alimentacion"));


        return "alimentacion";
    }




}