package com.neyser.consultasjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barcos")
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String matricula;
    private String nombre;
    private String amarre;
    private String cuota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socio_id")
    @JsonIgnore
    private Socio socio;

    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL)
    private List<Viaje> viajes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patron_id")
    @JsonIgnore
    private Patron patron;

}
