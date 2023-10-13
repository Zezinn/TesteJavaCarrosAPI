package repository;

import model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositorio JPA para carros
@Repository
public interface CarroRepository extends JpaRepository <Carro,Long> {
}
