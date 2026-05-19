package com.logitrack.api.controller;

import com.logitrack.api.model.Veiculo;
import com.logitrack.api.repository.VeiculoRepository;
import com.logitrack.api.factory.VeiculoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private VeiculoFactory factory;

    @GetMapping
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Veiculo adicionar(@RequestBody Veiculo dto) {
        // Garantindo que valores nulos não quebrem a Factory
        String status = (dto.getStatus() == null) ? "DISPONIVEL" : dto.getStatus();
        Double capacidade = (dto.getCapacidadeCarga() == null) ? 0.0 : dto.getCapacidadeCarga();

        Veiculo novoVeiculo = factory.criarVeiculo(
            dto.getPlaca(), 
            dto.getModelo(), 
            status, 
            capacidade
        );
        return repository.save(novoVeiculo);
    }

    // Método para deletar (Essencial para o CRUD completo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
