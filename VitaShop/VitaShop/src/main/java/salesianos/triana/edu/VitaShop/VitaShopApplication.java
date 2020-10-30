package salesianos.triana.edu.VitaShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Categoria;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Producto;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Usuario;
import salesianos.triana.edu.VitaShop.servicios.*;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VitaShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitaShopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, PasswordEncoder passwordEncoder, ProductoServicio productoServicio,
		CategoriaServicio categoriaServicio, PedidoServicio pedidoServicio, LineaPedidoServicio lineaPedidoServicio) {
		return args -> {

			Usuario u = new Usuario();
			u.setAdmin(false);
			u.setNombre("Luis Miguel");
			u.setApellidos("López");
			u.setEmail("luismi.lopez@email.com");
			u.setPassword(passwordEncoder.encode("1234"));
			u.setAccountNonLocked(true);

			servicio.save(u);


			Usuario a = new Usuario();
			a.setAdmin(true);
			a.setNombre("Ángel");
			a.setApellidos("Narajo");
			a.setEmail("angel.naranjo@email.com");
			a.setPassword(passwordEncoder.encode("1234"));
			a.setAccountNonLocked(true);

			servicio.save(a);

			Categoria c1 = new Categoria();
			c1.setNombre("Alimentación");

			categoriaServicio.save(c1);

			Categoria c2 = new Categoria();
			c2.setNombre("deportes");

			categoriaServicio.save(c2);

			Producto p1 = new Producto();
			p1.setNombre("Boniato");
			p1.setPrecio(1.90);
			p1.setEstado(true);


			Producto p2 = new Producto();
			p2.setNombre("Guisantes");
			p2.setPrecio(2.90);
			p2.setEstado(true);


			Producto p3 = new Producto();
			p3.setNombre("Brócoli");
			p3.setPrecio(0.90);
			p3.setEstado(true);

			Producto p4 = new Producto();
			p4.setNombre("Espinacas");
			p4.setPrecio(4.90);
			p4.setEstado(true);

			Producto p5 = new Producto();
			p5.setNombre("Kale");
			p5.setPrecio(2.90);
			p5.setEstado(true);

			Producto p6 = new Producto();
			p6.setNombre("Calabacín");
			p6.setPrecio(0.60);
			p6.setEstado(true);

			Producto p7 = new Producto();
			p7.setNombre("Remolacha");
			p7.setPrecio(1.20);
			p7.setEstado(true);

			Producto p8 = new Producto();
			p8.setNombre("Zanahorias");
			p8.setPrecio(2.79);
			p8.setEstado(true);

			Producto p9 = new Producto();
			p9.setNombre("Tomates");
			p9.setPrecio(7.79);
			p9.setEstado(true);

			Producto p10 = new Producto();
			p10.setNombre("Ajo");
			p10.setPrecio(9.10);
			p10.setEstado(true);

			Producto p11 = new Producto();
			p11.setNombre("Cebolla");
			p11.setPrecio(4.21);
			p11.setEstado(true);

			Producto p12 = new Producto();
			p12.setNombre("Brotes de alfalfa");
			p12.setPrecio(3.12);
			p12.setEstado(true);


			List<Producto> listaProductos = Arrays.asList(p1,p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);

			listaProductos.forEach(productoServicio::insertar);

		};
	}

}
