package com.logitrack.api.controller;

import com.logitrack.api.model.Veiculo;
import com.logitrack.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Veiculo adicionar(@RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }
}
