package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.PedidoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepository> {

    @Autowired
    PedidoRepository repositorio;

    @Autowired
    ProductoServicio productoServicio;

    public PedidoServicio(PedidoRepository repo) {
        super(repo);
    }

    public Pedido insertar(Pedido c, Usuario u) {
        c.setPropietario(u);
        return repositorio.save(c);
    }

    public Pedido insertar(Pedido c) {
        return repositorio.save(c);
    }

    public Producto addProductoCompra(Producto p, Pedido c) {
        p.setPedido(c);
        return productoServicio.editar(p);
    }

    public Pedido buscarPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }


    public List<Pedido> todas() {
        return repositorio.findAll();
    }

    public List<Pedido> porPropietario(Usuario u) {
        return repositorio.findByPropietario(u);
    }

}
