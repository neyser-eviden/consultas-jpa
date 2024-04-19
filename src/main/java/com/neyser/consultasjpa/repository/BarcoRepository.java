package com.neyser.consultasjpa.repository;

import com.neyser.consultasjpa.entity.Barco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Long> {
}
