package com.microservicioMuseo.Model;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Curador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;

    @ManyToMany(mappedBy = "curadores")
    private Set<Museo> museos;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Museo> getMuseos() {
        return museos;
    }

    public void setMuseos(Set<Museo> museos) {
        this.museos = museos;
    }
}