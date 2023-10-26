package com.example.tccapi.repository;

import com.example.tccapi.model.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Integer> {
}
