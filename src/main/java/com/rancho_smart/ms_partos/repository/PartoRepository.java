package com.rancho_smart.ms_partos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_partos.entity.Parto;

@Repository
public interface PartoRepository extends JpaRepository<Parto, Long>{
    
}
