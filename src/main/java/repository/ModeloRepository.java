package repository;

import model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositorio JPA Modelo para Modelos
@Repository
public interface ModeloRepository extends JpaRepository <Modelo,Long> {
}
