package service;

import model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ModeloRepository;
import java.util.List;
import java.util.Optional;

//classe ModeloService com a logica do CRUD para endpoint de Modelos
@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public Modelo createModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

    public Optional<Modelo> getModeloById(Long id) {
        return modeloRepository.findById(id);
    }

    public Optional<Modelo> updateModelo(Long id, Modelo modelo) {
        return modeloRepository.findById(id).map(existingModelo -> {
            existingModelo.setNome(modelo.getNome());
            existingModelo.setValorFipe(modelo.getValorFipe());
            return modeloRepository.save(existingModelo);
        });
    }

    public boolean deleteModelo(Long id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        if (modelo.isPresent()) {
            modeloRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
