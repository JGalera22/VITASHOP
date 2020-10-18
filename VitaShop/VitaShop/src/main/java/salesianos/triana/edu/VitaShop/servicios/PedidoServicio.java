package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.PedidoRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Pedido;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepository> {

    public PedidoServicio(PedidoRepository repo) {
        super(repo);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repositorio.findFirstById(id);
    }
}
