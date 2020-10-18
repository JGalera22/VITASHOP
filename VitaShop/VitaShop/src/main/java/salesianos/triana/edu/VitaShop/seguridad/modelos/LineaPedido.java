package salesianos.triana.edu.VitaShop.seguridad.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class LineaPedido {

    @Id @GeneratedValue
    private Long id;

    private int idPedido;
    private int idProducto;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Producto producto;

    public LineaPedido(int idPedido, int idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public LineaPedido(int idPedido, int idProducto, Pedido pedido) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.pedido = pedido;
    }

    public LineaPedido(int idPedido, int idProducto, Pedido pedido, Producto producto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.pedido = pedido;
        this.producto = producto;
    }
}
