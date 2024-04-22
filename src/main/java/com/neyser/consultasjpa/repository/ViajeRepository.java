package com.neyser.consultasjpa.repository;

import com.neyser.consultasjpa.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    @Query("select v from Viaje v where v.id = ?1")
    Viaje buscarViajePorId(Long id);
}
