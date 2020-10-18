package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.LineaPedido;

import java.util.Optional;

public interface LineaPedidoRepository
        extends JpaRepository<LineaPedido, Long> {
    Optional<LineaPedido> findFirstById(Long Id);
}
