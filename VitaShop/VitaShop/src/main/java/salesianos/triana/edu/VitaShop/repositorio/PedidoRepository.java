package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

import java.util.List;
import java.util.Optional;


public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findFirstById(Long Id);

    List<Pedido> findByPropietario(Usuario propietario);
}
