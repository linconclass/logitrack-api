package com.logitrack.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    private String status;

    private Double capacidadeCarga;

    // Getters e Setters (Padrão JEE)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getCapacidadeCarga() { return capacidadeCarga; }
    public void setCapacidadeCarga(Double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }
}
