package service;

import model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MarcaRepository;
import java.util.Optional;
import java.util.List;



//classe MarcaService com a logica do CRUD para endpoint de Marcas
@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> getMarcaById(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca createMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Optional<Marca> updateMarca(Long id, Marca updatedMarca) {
        if (marcaRepository.existsById(id)) {
            updatedMarca.setId(id);
            return Optional.of(marcaRepository.save(updatedMarca));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteMarca(Long id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
