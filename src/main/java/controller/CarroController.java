package controller;

import model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.CarroResponse;
import service.CarroService;

import java.util.List;
import java.util.Optional;

//Controller para endpoint de carros na API
//seguindo a implementacao com a logica para cada acao do endpoint
@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Carro> createCar(@RequestBody Carro car) {
        Carro createCarro = carroService.createCarro(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCarro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> getCarById(@PathVariable Long id) {
        Optional<CarroResponse> car = carroService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CarroResponse>> getAllCars() {
        List<CarroResponse> cars = carroService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable Long id, @RequestBody Carro car) {
        Optional<Carro> updatedCar = carroService.updateCarro(id, car);
        return updatedCar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
        if (carroService.deleteCarro(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
