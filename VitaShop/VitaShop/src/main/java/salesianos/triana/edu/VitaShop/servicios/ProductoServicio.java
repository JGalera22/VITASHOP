package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.ProductoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio extends BaseService<Producto, Long, ProductoRepository> {


    public ProductoServicio(ProductoRepository repo) {
        super(repo);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repositorio.findFirstById(id);
    }

    public Producto insertar(Producto p) {
        return repositorio.save(p);
    }

    public void borrar(Producto p) {
        repositorio.delete(p);
    }

    public void borrar(long id) {
        repositorio.deleteById(id);
    }

    public Producto editar(Producto p) {
        return repositorio.save(p);
    }

    public Producto findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    public List<Producto> productosDeUnPropietario(Usuario u) {
        return repositorio.findByPropietario(u);
    }

    public List<Producto> productosSinVender() {
        return repositorio.findByPedidoIsNull();
    }

    public List<Producto> buscar(String query) {
        return repositorio.findByNombreContainsIgnoreCaseAndPedidoIsNull(query);
    }

    public List<Producto> buscarMisProductos(String query, Usuario u) {
        return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query,u);
    }

    public List<Producto> productosDeUnPedido(Pedido pe) {
        return repositorio.findByPedido(pe);
    }

    public List<Producto> variosPorId(List<Long> ids) {
        return repositorio.findAllById(ids);
    }
}
