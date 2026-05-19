package com.logitrack.api.service;

import com.logitrack.api.model.Veiculo;
import com.logitrack.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        // Aqui poderiam entrar padrões comportamentais de validação
        return repository.save(veiculo);
    }
}
