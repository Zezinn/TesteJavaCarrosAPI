package repository;

import model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositorio JPA para Marcas
@Repository
public interface MarcaRepository extends JpaRepository <Marca,Long> {
}
