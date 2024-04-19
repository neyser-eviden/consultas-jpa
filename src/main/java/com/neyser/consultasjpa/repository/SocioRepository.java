package com.neyser.consultasjpa.repository;

import com.neyser.consultasjpa.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("select s from Socio s where s.id = ?1")
    Socio buscarSocioPorId(Long id);
}
