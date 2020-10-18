package salesianos.triana.edu.VitaShop.seguridad.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fecha;
    private int idCliente;
    private String estado;

    @ManyToOne
    private Usuario usuario;

    public Pedido( LocalDate fecha, int idCliente, String estado) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public Pedido(LocalDate fecha, int idCliente, String estado, Usuario usuario) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.estado = estado;
        this.usuario = usuario;
    }
}
