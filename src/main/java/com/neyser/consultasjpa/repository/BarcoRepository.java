package com.neyser.consultasjpa.repository;

import com.neyser.consultasjpa.entity.Barco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Long> {
    @Query("select b from Barco b where b.id = ?1")
    Barco buscarBarcoPorId(Long id);
}
