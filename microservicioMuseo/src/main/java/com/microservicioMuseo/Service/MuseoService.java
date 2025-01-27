package com.microservicioMuseo.Service;

import com.microservicioMuseo.Model.Museo;
import com.microservicioMuseo.Repository.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseoService {

    @Autowired
    private MuseoRepository museoRepository;

    public List<Museo> obtenerTodos() {
        return museoRepository.findAll();
    }

    public Optional<Museo> obtenerPorId(Long id) {
        return museoRepository.findById(id);
    }

    public Museo guardar(Museo museo) {
        return museoRepository.save(museo);
    }

    public void eliminar(Long id) {
        museoRepository.deleteById(id);
    }
}