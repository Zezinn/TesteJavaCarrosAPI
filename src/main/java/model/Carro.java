package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

//Entidade JPA Carro da API
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime timestampCadastro;
    private Long modeloId;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

}



