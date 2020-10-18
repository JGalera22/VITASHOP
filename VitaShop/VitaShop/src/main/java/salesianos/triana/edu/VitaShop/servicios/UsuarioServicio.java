package salesianos.triana.edu.VitaShop.servicios;


import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.UsuarioRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, UsuarioRepository> {

    public UsuarioServicio(UsuarioRepository repo) {
        super(repo);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repositorio.findFirstByEmail(email);
    }

}