package salesianos.triana.edu.VitaShop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findFirstByEmail(String email);


}