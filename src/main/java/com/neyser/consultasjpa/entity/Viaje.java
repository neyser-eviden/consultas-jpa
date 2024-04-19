package com.neyser.consultasjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaSalida;

    @Basic
    private String destino;

    @ManyToOne
    @JoinColumn(name = "barco_id")
    @JsonIgnore
    private Barco barco;





}
