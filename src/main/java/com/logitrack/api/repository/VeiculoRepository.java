package com.logitrack.api.repository;

import com.logitrack.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // Aqui você já ganha métodos como save, findAll e delete automaticamente.
}
