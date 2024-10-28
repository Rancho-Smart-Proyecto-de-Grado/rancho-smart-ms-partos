package com.rancho_smart.ms_partos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_partos.entity.Parto;
import com.rancho_smart.ms_partos.repository.PartoRepository;

@Service
public class PartoService {

    @Autowired
    private PartoRepository partoRepository;

    public List<Parto> getPartos() {
        return this.partoRepository.findAll();
    }

    public Optional<Parto> getPartoById(Long id) {
        return this.partoRepository.findById(id);
    }

    public Parto saveParto(Parto parto) {
        return this.partoRepository.save(parto);
    }

    public void deleteParto(Long id) {
        this.partoRepository.deleteById(id);
    }
}
