package salesianos.triana.edu.VitaShop.seguridad.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fecha;
    private int idCliente;
    private String estado;

    @ManyToOne
    private Usuario propietario;

    public Pedido( LocalDate fecha, int idCliente, String estado) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public Pedido(LocalDate fecha, int idCliente, String estado, Usuario propietario) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.estado = estado;
        this.propietario = propietario;
    }

    public Pedido() {}


    public Pedido(Usuario propietario) {
        this.propietario = propietario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id != other.id)
            return false;
        if (propietario == null) {
            if (other.propietario != null)
                return false;
        } else if (!propietario.equals(other.propietario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Compra [id=" + id + ", propietario=" + propietario + "]";
    }
}
