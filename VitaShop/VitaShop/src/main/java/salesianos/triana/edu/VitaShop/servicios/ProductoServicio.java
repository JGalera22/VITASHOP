package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.ProductoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

@Service
public class ProductoServicio extends BaseService<Producto, Long, ProductoRepository> {

    public ProductoServicio(ProductoRepository repo) {
        super(repo);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repositorio.findFirstById(id);
    }
}
