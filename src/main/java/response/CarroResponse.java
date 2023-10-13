package response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.Carro;
import model.Modelo;
import java.time.LocalDateTime;

//Classe response com getter e setter para o endpoint de carros da API
@Data
@Getter
@Setter
public class CarroResponse {
    private Long id;
    private LocalDateTime timestampCadastro;
    private Long modeloId;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;
    private String nomeModelo;
    private double valor;

    public CarroResponse(Carro carro , Modelo modelo) {
        this.id = carro.getId();
        this.timestampCadastro = carro.getTimestampCadastro();
        this.modeloId = carro.getModeloId();
        this.ano = carro.getAno();
        this.combustivel = carro.getCombustivel();
        this.numPortas = carro.getNumPortas();
        this.cor = carro.getCor();

        if (modelo != null) {
            this.nomeModelo = modelo.getNome();
            this.valor = modelo.getValorFipe();
        } else {
            this.nomeModelo = "Modelo não encontrado";
            this.valor = 0.0;
        }
    }


}
