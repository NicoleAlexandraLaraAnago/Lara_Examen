package com.microservicioCurador.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Museo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Se puede añadir para garantizar que el nombre no sea nulo
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "museo_curador",
            joinColumns = @JoinColumn(name = "museo_id"),
            inverseJoinColumns = @JoinColumn(name = "curador_id")
    )
    private Set<Curador> curadores = new HashSet<>();

    // Constructor vacío (opcional)
    public Museo() {}

    // Constructor con nombre (opcional)
    public Museo(String nombre) {
        this.nombre = nombre;
    }

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
