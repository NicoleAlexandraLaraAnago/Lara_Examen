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

    public Curador asignarCuradorAMuseo(Long curadorId, Long museoId) {
        Optional<Curador> curadorOptional = curadorRepository.findById(curadorId);
        Optional<Museo> museoOptional = museoRepository.findById(museoId);

        if (curadorOptional.isPresent() && museoOptional.isPresent()) {
            Curador curador = curadorOptional.get();
            Museo museo = museoOptional.get();
            museo.getCuradores().add(curador);
            museoRepository.save(museo);
            return curador;
        }
        return null;
    }

    public Iterable<Curador> listarCuradoresDeMuseo(Long museoId) {
        Optional<Museo> museoOptional = museoRepository.findById(museoId);
        if (museoOptional.isPresent()) {
            return museoOptional.get().getCuradores();
        }
        return null;
    }

    public Iterable<Museo> listarMuseosDeCurador(Long curadorId) {
        Optional<Curador> curadorOptional = curadorRepository.findById(curadorId);
        if (curadorOptional.isPresent()) {
            return curadorOptional.get().getMuseos();
        }
        return null;
    }
}
