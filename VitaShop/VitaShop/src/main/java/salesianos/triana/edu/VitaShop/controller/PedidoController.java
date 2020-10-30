package salesianos.triana.edu.VitaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.PedidoServicio;
import salesianos.triana.edu.VitaShop.servicios.ProductoServicio;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class PedidoController {

    @Autowired
    PedidoServicio pedidoServicio;

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    HttpSession session;

    private Usuario usuario;


    @ModelAttribute("carrito")
    public List<Producto> productosCarrito() {
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        return (contenido == null) ? null : productoServicio.variosPorId(contenido);
    }

    @ModelAttribute("total_carrito")
    public Double totalCarrito() {
        List<Producto> productosCarrito = productosCarrito();
        if (productosCarrito != null)
            return productosCarrito.stream()
                    .mapToDouble(p -> p.getPrecio())
                    .sum();
        return 0.0;
    }

    @ModelAttribute("mis_compras")
    public List<Pedido> misCompras() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        usuario = usuarioServicio.buscarPorEmail(email);
        return pedidoServicio.porPropietario(usuario);
    }


    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        return "app/compra/carrito";
    }

    @GetMapping("/carrito/add/{id}")
    public String addCarrito(Model model, @PathVariable Long id) {
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            contenido = new ArrayList<>();
        if (!contenido.contains(id))
            contenido.add(id);
        session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";
    }

    @GetMapping("/carrito/eliminar/{id}")
    public String borrarDeCarrito(Model model, @PathVariable Long id) {
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/index";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito");
        else
            session.setAttribute("carrito", contenido);
        return "redirect:/app/carrito";

    }

    @GetMapping("/carrito/finalizar")
    public String checkout() {
        List<Long> contenido = (List<Long>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/public";

        List<Producto> productos = productosCarrito();

        Pedido pe = pedidoServicio.insertar(new Pedido(), usuario);

        productos.forEach(p -> pedidoServicio.addProductoCompra(p, pe));
        session.removeAttribute("carrito");

        return "redirect:/app/compra/factura/"+pe.getId();

    }


    @GetMapping("/miscompras")
    public String verMisCompras(Model model) {
        return "/app/compra/listado";
    }


    @GetMapping("/compra/factura/{id}")
    public String factura(Model model, @PathVariable Long id) {
        Pedido pe = pedidoServicio.buscarPorId(id);
        List<Producto> productos = productoServicio.productosDeUnPedido(pe);
        model.addAttribute("productos", productos);
        model.addAttribute("compra", pe);
        model.addAttribute("total_compra", productos.stream().mapToDouble(p -> p.getPrecio()).sum());
        return "/app/compra/factura";
    }





}
