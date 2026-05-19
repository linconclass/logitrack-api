package com.logitrack.api.controller;

import com.logitrack.api.model.Veiculo;
import com.logitrack.api.repository.VeiculoRepository;
import com.logitrack.api.factory.VeiculoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private VeiculoFactory factory; // GRASP: Delegation

    @GetMapping
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Veiculo adicionar(@RequestBody Veiculo dto) {
        // Usando a Factory (Padrão de Criação GoF) para instanciar o objeto
        Veiculo novoVeiculo = factory.criarVeiculo(
            dto.getPlaca(), 
            dto.getModelo(), 
            dto.getStatus(), 
            dto.getCapacidadeCarga()
        );
        return repository.save(novoVeiculo);
    }
}
