package com.microservicioCurador.Controller;

import com.microservicioCurador.Model.Curador;
import com.microservicioCurador.Model.Museo;
import com.microservicioCurador.Service.CuradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curadores")
public class CuradorController {

    @Autowired
    private CuradorService curadorService;

    @PostMapping("/asignar/{curadorId}/{museoId}")
    public Curador asignarCuradorAMuseo(@PathVariable Long curadorId, @PathVariable Long museoId) {
        return curadorService.asignarCuradorAMuseo(curadorId, museoId);
    }

    @GetMapping("/museos/{curadorId}")
    public Iterable<Museo> listarMuseosDeCurador(@PathVariable Long curadorId) {
        return curadorService.listarMuseosDeCurador(curadorId);
    }

    @GetMapping("/curadores/{museoId}")
    public Iterable<Curador> listarCuradoresDeMuseo(@PathVariable Long museoId) {
        return curadorService.listarCuradoresDeMuseo(museoId);
    }
}
