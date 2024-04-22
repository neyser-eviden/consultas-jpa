package com.neyser.consultasjpa.repository;

import com.neyser.consultasjpa.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    @Query("select p from Patron p where p.id = ?1")
    Patron buscarPatronPorId(Long id);
}
