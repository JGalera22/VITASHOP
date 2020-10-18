package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;

import java.util.Optional;


public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findFirstById(Long Id);
}
