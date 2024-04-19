package com.neyser.consultasjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patrones")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @Temporal(TemporalType.DATE)
    private Date fecha_registro;

    @ManyToMany(mappedBy = "patrones")
    private List<Socio> socios;


}
