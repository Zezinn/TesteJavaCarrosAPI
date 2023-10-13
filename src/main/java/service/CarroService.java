package service;

import model.Carro;
import model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarroRepository;
import repository.ModeloRepository;
import response.CarroResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//classe CarroService com a logica do CRUD para endpoint de Carros
@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public List<CarroResponse> getAllCars() {
        List<Carro> carros = carroRepository.findAll();
        List<CarroResponse> carroResponses = new ArrayList<>();

        for (Carro car : carros) {
            Optional<Modelo> modelo = modeloRepository.findById(car.getModeloId());
            modelo.ifPresent(m -> carroResponses.add(new CarroResponse(car, m)));
        }

        return carroResponses;
    }


    public Optional<CarroResponse> getCarById(Long id) {
        Optional<Carro> car = carroRepository.findById(id);
        if (car.isPresent()) {
            Optional<Modelo> modelo = modeloRepository.findById(car.get().getModeloId());
            return modelo.map(m -> Optional.of(new CarroResponse(car.get(), m))).orElseGet(() -> Optional.of(new CarroResponse(car.get(), null)));
        } else {
            return Optional.empty();
        }
    }

    public Carro createCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Optional<Carro> updateCarro(Long id, Carro updatedCarro) {
        if (carroRepository.existsById(id)) {
            updatedCarro.setId(id);
            return Optional.of(carroRepository.save(updatedCarro));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteCarro(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
