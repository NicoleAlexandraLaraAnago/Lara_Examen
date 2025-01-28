package com.microservicioCurador.Service;

import com.microservicioCurador.Model.Curador;
import com.microservicioCurador.Model.Museo;
import com.microservicioCurador.Repository.CuradorRepository;
import com.microservicioCurador.Repository.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuradorService {

    @Autowired
    private CuradorRepository curadorRepository;

    @Autowired
    private MuseoRepository museoRepository;

    // Asignar un curador a un museo
    public Curador asignarCuradorAMuseo(Long curadorId, Long museoId) {
        Optional<Curador> curadorOptional = curadorRepository.findById(curadorId);
        Optional<Museo> museoOptional = museoRepository.findById(museoId);

        if (curadorOptional.isPresent() && museoOptional.isPresent()) {
            Curador curador = curadorOptional.get();
            Museo museo = museoOptional.get();

            // Verificar si el curador ya está asignado al museo
            if (museo.getCuradores().contains(curador)) {
                throw new RuntimeException("El curador ya está asignado a este museo.");
            }

            museo.getCuradores().add(curador);
            museoRepository.save(museo);
            return curador;
        }
        throw new RuntimeException("Curador o museo no encontrado.");
    }

    // Listar los curadores que están asignados a un museo
    public Iterable<Curador> listarCuradoresDeMuseo(Long museoId) {
        Optional<Museo> museoOptional = museoRepository.findById(museoId);
        if (museoOptional.isPresent()) {
            return museoOptional.get().getCuradores();
        }
        throw new RuntimeException("Museo no encontrado.");
    }

    // Listar los museos en los que trabaja un curador
    public Iterable<Museo> listarMuseosDeCurador(Long curadorId) {
        Optional<Curador> curadorOptional = curadorRepository.findById(curadorId);
        if (curadorOptional.isPresent()) {
            return curadorOptional.get().getMuseos();
        }
        throw new RuntimeException("Curador no encontrado.");
    }

    // Crear un nuevo curador
    public Curador crearCurador(Curador curador) {
        return curadorRepository.save(curador);
    }
}
