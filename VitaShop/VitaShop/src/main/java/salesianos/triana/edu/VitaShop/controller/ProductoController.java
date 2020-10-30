package salesianos.triana.edu.VitaShop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import salesianos.triana.edu.VitaShop.repositorio.Carrito;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.CategoriaServicio;
import salesianos.triana.edu.VitaShop.servicios.ProductoServicio;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class ProductoController {

        private final Carrito carrito;


        @ModelAttribute("productos")
        public List<Producto> todosLosProductos() {
            return productoServicio.findAll();
        }


    /**
     * Métodos asociados a las listas de productos
     */

     @Autowired
        ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

        private Usuario usuario;

        @ModelAttribute("productos")
        public List<Producto> productosNoVendidos(){
            return productoServicio.productosSinVender();
        }


        @GetMapping("/producto/{id}")
        public String showProdcutModel(Model model, @PathVariable Long id){
            Producto result = productoServicio.findById(id);
            if (result != null){
                model.addAttribute("producto" , result);
            }
            return "redirect:/index";
        }

/*    @ModelAttribute("misproductos")
    public List<Producto> misProductos() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        usuario = usuarioServicio.buscarPorEmail(email);
        return productoServicio.productosDeUnPropietario(usuario);
    }*/

    @GetMapping("/misproductos")
    public String list(Model model, @RequestParam(name = "q", required = false) String query) {
        if (query != null)
            model.addAttribute("misproductos", productoServicio.buscarMisProductos(query, usuario));

        return "app/producto/lista";
    }

    @GetMapping("/misproductos/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        Producto p = productoServicio.findById(id);
        if (p.getPedido() == null)
            productoServicio.borrar(p);
        return "redirect:/app/misproductos";
    }



    @GetMapping("/producto/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaServicio.findAll());
        return "app/producto/form";
    }




    @PostMapping("/producto/nuevo/submit")
    public String nuevoProductoSubmit(@ModelAttribute Producto p) {
        p.setPropietario(usuario);
        if (p.getCategoria().equals(categoriaServicio.buscarPorNombre("alimentacion"))){
            productoServicio.insertar(p);;
            return "redirect:/alimentacion";
        } else if (p.getCategoria().equals(categoriaServicio.buscarPorNombre("deportes"))){
            productoServicio.insertar(p);;
            return "redirect:/deportes";
        } else{
            return "redirect:/index";
        }
    }



    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        Producto p = productoServicio.findById(id);
        if (p != null){
            if (p.getCategoria().equals(categoriaServicio.buscarPorNombre("alimentacion"))){
                productoServicio.borrar(p);
                return "redirect:/alimentacion";
            } else{
                productoServicio.borrar(p);
                return "redirect:/deportes";
            }
        }
        return "redirect:/index";
    }


    @GetMapping("/producto/editar/{id}")
    public String editarProductoForm(@PathVariable Long id, Model model) {
        Producto p = productoServicio.findById(id);
        model.addAttribute("producto", p);
        return "app/producto/form";
    }

    @Autowired
    CategoriaServicio categoriaServicio;

    @PostMapping("/producto/editar/submit")
    public String editarProductoSubmit(@ModelAttribute Producto p) { ;
        if (p.getCategoria().equals(categoriaServicio.buscarPorNombre("alimentacion"))){
            productoServicio.editar(p);
            return "redirect:/alimentacion";
        } else{
            productoServicio.editar(p);
            return "redirect:/deportes";
        }
    }

}
