package com.microservicioCurador.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Museo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "museo_curador",
            joinColumns = @JoinColumn(name = "museo_id"),
            inverseJoinColumns = @JoinColumn(name = "curador_id")
    )
    private Set<Curador> curadores = new HashSet<>();

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

    public Set<Curador> getCuradores() {
        return curadores;
    }

    public void setCuradores(Set<Curador> curadores) {
        this.curadores = curadores;
    }
}
