package salesianos.triana.edu.VitaShop.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import salesianos.triana.edu.VitaShop.repositorio.UsuarioRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;
    private final UsuarioServicio usuarioServicio;
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioServicio.buscarPorEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username != null){
            return usuarioServicio.buscarPorEmail(username);
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByEmail(username);

        User.UserBuilder builder = null;

        if (usuario != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();
    }*/

}
