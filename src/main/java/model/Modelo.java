package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entidade JPA Modelo da API
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long marcaId;
    private String nome;
    private double valorFipe;

}
