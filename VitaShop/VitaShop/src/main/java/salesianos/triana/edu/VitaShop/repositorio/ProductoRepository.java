package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;

import java.util.Optional;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {
    Optional<Producto> findFirstById(Long id);
}
