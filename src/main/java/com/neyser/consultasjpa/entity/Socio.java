package com.neyser.consultasjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Barco> barcos;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "socio_patron", joinColumns = @JoinColumn(name = "socio_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patron_id", referencedColumnName = "id")
    )
    private List<Patron> patrones;

}
