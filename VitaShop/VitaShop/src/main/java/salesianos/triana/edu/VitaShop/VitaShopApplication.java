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
			c1.setNombre("alimentacion");

			categoriaServicio.save(c1);

			Categoria c2 = new Categoria();
			c2.setNombre("deportes");

			categoriaServicio.save(c2);

			Producto p1 = new Producto();
			p1.setNombre("1Kg Boniato");
			p1.setPrecio(1.90);
			p1.setEstado(true);
			p1.setCategoria(c1);



			Producto p2 = new Producto();
			p2.setNombre("1Kg Guisantes");
			p2.setPrecio(2.90);
			p2.setEstado(true);
			p2.setCategoria(c1);


			Producto p3 = new Producto();
			p3.setNombre("1Kg Brócoli");
			p3.setPrecio(0.90);
			p3.setEstado(true);
			p3.setCategoria(c1);

			Producto p4 = new Producto();
			p4.setNombre("1Kg Espinacas");
			p4.setPrecio(4.90);
			p4.setEstado(true);
			p4.setCategoria(c1);

			Producto p5 = new Producto();
			p5.setNombre("1Kg Kale");
			p5.setPrecio(2.90);
			p5.setEstado(true);
			p5.setCategoria(c1);

			Producto p6 = new Producto();
			p6.setNombre(" 0.5Kg Calabacín");
			p6.setPrecio(0.60);
			p6.setEstado(true);
			p6.setCategoria(c1);

			Producto p7 = new Producto();
			p7.setNombre("1Kg Remolacha");
			p7.setPrecio(1.20);
			p7.setEstado(true);
			p7.setCategoria(c1);

			Producto p8 = new Producto();
			p8.setNombre("1Kg Zanahorias");
			p8.setPrecio(2.79);
			p8.setEstado(true);
			p8.setCategoria(c1);

			Producto p9 = new Producto();
			p9.setNombre("5Kg Tomates");
			p9.setPrecio(7.79);
			p9.setEstado(true);
			p9.setCategoria(c1);

			Producto p10 = new Producto();
			p10.setNombre("5Kg Ajo");
			p10.setPrecio(9.10);
			p10.setEstado(true);
			p10.setCategoria(c1);

			Producto p11 = new Producto();
			p11.setNombre("Babolat Pure Aero Unstrung NC");
			p11.setPrecio(183.00);
			p11.setEstado(true);
			p11.setCategoria(c2);

			Producto p12 = new Producto();
			p12.setNombre("Bicicleta BMX");
			p12.setPrecio(149.95);
			p12.setEstado(true);
			p12.setCategoria(c2);

			Producto p13 = new Producto();
			p13.setNombre("TOMSHOO Kit de Rueda Abdominal");
			p13.setPrecio(149.95);
			p13.setEstado(true);
			p13.setCategoria(c2);

			Producto p14 = new Producto();
			p14.setNombre("Xiaomi Band 5, Unisex Adulto");
			p14.setPrecio(31.84);
			p14.setEstado(true);
			p14.setCategoria(c2);

			Producto p15 = new Producto();
			p15.setNombre("PROIRON Mancuernas de Neopreno");
			p15.setPrecio(31.84);
			p15.setEstado(true);
			p15.setCategoria(c2);

			Producto p16 = new Producto();
			p16.setNombre("INTEY Bandas Elásticas, 13 PCS");
			p16.setPrecio(31.84);
			p16.setEstado(true);
			p16.setCategoria(c2);

			Producto p17 = new Producto();
			p17.setNombre("Bandas Elasticas Gluteos");
			p17.setPrecio(31.84);
			p17.setEstado(true);
			p17.setCategoria(c2);


			List<Producto> listaProductos = Arrays.asList(p1,p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
					p14, p15, p16, p17);

			listaProductos.forEach(productoServicio::insertar);

		};
	}

}
