package salesianos.triana.edu.VitaShop.servicios;

import salesianos.triana.edu.VitaShop.repositorio.LineaPedidoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.LineaPedido;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

public class LineaPedidoServicio extends BaseService<LineaPedido, Long, LineaPedidoRepository> {

    public LineaPedidoServicio(LineaPedidoRepository repo) {
        super(repo);
    }

    public Optional<LineaPedido> buscarPorId(Long id) {
        return repositorio.findFirstById(id);
    }
}
