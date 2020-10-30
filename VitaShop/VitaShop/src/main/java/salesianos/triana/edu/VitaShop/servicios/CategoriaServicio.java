package salesianos.triana.edu.VitaShop.servicios;

import org.springframework.stereotype.Service;
import salesianos.triana.edu.VitaShop.repositorio.CategoriaRepository;
import salesianos.triana.edu.VitaShop.seguridad.modelos.Categoria;
import salesianos.triana.edu.VitaShop.servicios.base.BaseService;

import java.util.Optional;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepository> {


    public CategoriaServicio(CategoriaRepository repo) {
        super(repo);
    }

    public Categoria buscarPorNombre(String nombre) {
        Categoria categoria = new Categoria();
        for (Categoria c : this.findAll()){
            if (c.getNombre().equals(nombre)){
                categoria = c;
            }
        }
        return categoria;
    }
}
