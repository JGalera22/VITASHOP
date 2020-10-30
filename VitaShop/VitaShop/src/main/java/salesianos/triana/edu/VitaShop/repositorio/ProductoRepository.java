package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {
    Optional<Producto> findFirstById(Long id);

    List<Producto> findByPropietario(Usuario propietario);

    List<Producto> findByPedido(Pedido pedido);

    List<Producto> findByPedidoIsNull();

    List<Producto> findByNombreContainsIgnoreCaseAndPedidoIsNull(String nombre);

    List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
}
