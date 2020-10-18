package salesianos.triana.edu.VitaShop.seguridad.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, estado;
    private double precio;

    @ManyToOne
    private Categoria categoria;

    public Producto(String nombre, String estado, double precio) {
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
    }

    public Producto(String nombre, String estado, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.categoria = categoria;
    }
}
