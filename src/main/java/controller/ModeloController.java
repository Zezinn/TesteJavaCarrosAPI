package controller;

import model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ModeloService;
import java.util.List;
import java.util.Optional;

//Controller para endpoints de modelo na API
@RestController
@RequestMapping("/modelos")
public class ModeloController {
    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<Modelo> createModelo(@RequestBody Modelo modelo) {
        Modelo createdModelo = modeloService.createModelo(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModelo);
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos() {
        List<Modelo> modelos = modeloService.getAllModelos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable Long id) {
        Optional<Modelo> modelo = modeloService.getModeloById(id);
        return modelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Optional<Modelo> updatedModelo = modeloService.updateModelo(id, modelo);
        return updatedModelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        if (modeloService.deleteModelo(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
