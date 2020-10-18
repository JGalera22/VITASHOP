package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.LineaPedidoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.LineaPedido;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

@Service
public class LineaPedidoServicio extends BaseService<LineaPedido, Long, LineaPedidoRepository> {

    public LineaPedidoServicio(LineaPedidoRepository repo) {
        super(repo);
    }

    public Optional<LineaPedido> buscarPorId(Long id) {
        return repositorio.findFirstById(id);
    }
}
