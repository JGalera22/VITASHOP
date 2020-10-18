package salesianos.triana.edu.VitaShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.UsuarioServicio;

@SpringBootApplication
public class VitaShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitaShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, PasswordEncoder passwordEncoder) {
		return args -> {

			Usuario u = new Usuario();
			u.setAdmin(false);
			u.setNombre("Luis Miguel");
			u.setApellidos("López");
			u.setEmail("luismi.lopez@email.com");
			u.setPassword(passwordEncoder.encode("1234"));
			u.setAccountNonLocked(false);

			servicio.save(u);


			Usuario a = new Usuario();
			a.setAdmin(true);
			a.setNombre("Ángel");
			a.setApellidos("Narajo");
			a.setEmail("angel.naranjo@email.com");
			a.setPassword(passwordEncoder.encode("1234"));
			a.setAccountNonLocked(true);

			servicio.save(a);
		};
	}
}
