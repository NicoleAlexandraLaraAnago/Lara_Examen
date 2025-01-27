package com.microservicioMuseo.Service;

import com.microservicioMuseo.Model.Curador;
import com.microservicioMuseo.Repository.CuradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuradorService {

    @Autowired
    private CuradorRepository curadorRepository;

    public List<Curador> obtenerTodos() {
        return curadorRepository.findAll();
    }

    public Optional<Curador> obtenerPorId(Long id) {
        return curadorRepository.findById(id);
    }

    public Curador guardar(Curador curador) {
        return curadorRepository.save(curador);
    }

    public void eliminar(Long id) {
        curadorRepository.deleteById(id);
    }
}