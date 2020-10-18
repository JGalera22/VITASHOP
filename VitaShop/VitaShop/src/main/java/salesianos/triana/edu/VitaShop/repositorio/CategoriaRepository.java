package salesianos.triana.edu.VitaShop.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Categoria;

import java.util.Optional;

public interface CategoriaRepository
        extends JpaRepository <Categoria, Long> {
    Optional<Categoria> findFirstByName(String nombre);
}
