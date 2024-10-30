package com.rancho_smart.ms_partos.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARTO")
public class Parto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idParto;

    @Column(name = "ID_ANIMAL")
    private Long idAnimal;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "ID_MADRE")
    private Long idMadre;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "FOTO")
    private byte[] foto;

    public Parto() {
    }

    public Parto(Long idAnimal, LocalDateTime fecha, Long idMadre, String observaciones) {
        this.idAnimal = idAnimal;
        this.fecha = fecha;
        this.idMadre = idMadre;
        this.observaciones = observaciones;
    }

    public Parto(Long idAnimal, LocalDateTime fecha, Long idMadre, String observaciones, byte[] foto) {
        this.idAnimal = idAnimal;
        this.fecha = fecha;
        this.idMadre = idMadre;
        this.observaciones = observaciones;
        this.foto = foto;
    }

    public Long getIdParto() {
        return idParto;
    }

    public void setIdParto(Long idParto) {
        this.idParto = idParto;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getIdMadre() {
        return idMadre;
    }

    public void setIdMadre(Long idMadre) {
        this.idMadre = idMadre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }    
}
