package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.LineaPedido;

public interface LineaPedidoRepository
        extends JpaRepository<LineaPedido, Long> {
}
