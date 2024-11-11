package com.rancho_smart.ms_partos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_partos.entity.Parto;
import java.util.List;


@Repository
public interface PartoRepository extends JpaRepository<Parto, Long>{
    public List<Parto> findByIdAnimal(Long idAnimal);
    public List<Parto> findByIdMadre(Long idMadre);
    public List<Parto> findByIdFinca(Long idFinca);
    public List<Parto> findByIdUsuario(Long idUsuario);
}
