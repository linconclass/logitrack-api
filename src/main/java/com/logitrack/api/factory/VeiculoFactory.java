package com.logitrack.api.factory;

import com.logitrack.api.model.Veiculo;
import org.springframework.stereotype.Component;

@Component  // GRASP: Creator - Esta classe é responsável por criar instâncias de Veiculo.
public class VeiculoFactory {
    public Veiculo criarVeiculo(String placa, String modelo, String status, Double capacidadeCarga) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setStatus(status);
        veiculo.setCapacidadeCarga(capacidadeCarga);
        return veiculo;
    }
}
