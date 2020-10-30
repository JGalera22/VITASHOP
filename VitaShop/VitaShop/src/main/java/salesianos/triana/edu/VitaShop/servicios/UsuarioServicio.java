package salesianos.triana.edu.VitaShop.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.UsuarioRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, UsuarioRepository> {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioServicio(UsuarioRepository repo) {
        super(repo);
    }

    public Usuario buscarPorEmail(String email) {
        return repositorio.findFirstByEmail(email);
    }

    public Usuario registrar(Usuario u, BCryptPasswordEncoder passwordEncoder){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioRepository.save(u);
    }

}