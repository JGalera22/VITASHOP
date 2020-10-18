package salesianos.triana.edu.VitaShop.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Categoria;

public interface CategoriaRepository
        extends JpaRepository <Categoria, Long> {
}
