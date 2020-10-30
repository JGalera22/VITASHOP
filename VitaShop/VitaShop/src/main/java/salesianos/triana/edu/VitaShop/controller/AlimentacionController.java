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
@RequestMapping("/alimentacion")
public class AlimentacionController {

    private Usuario usuario;

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping("/")
    public String alimentacion() {
        return "alimentacion";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "app/producto/lista";
    }

    @PostMapping("/producto/nuevo/submit")
    public String nuevoProductoSubmit(@ModelAttribute("producto") Producto producto) {
        producto.setPropietario(usuario);
        productoServicio.insertar(producto);
        return "redirect:/app/misproductos";
    }

}