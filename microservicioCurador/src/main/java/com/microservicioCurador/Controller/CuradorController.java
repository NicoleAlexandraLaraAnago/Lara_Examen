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

    // Asignar un curador a un museo
    @PostMapping("/asignar/{curadorId}/{museoId}")
    public Curador asignarCuradorAMuseo(@PathVariable Long curadorId, @PathVariable Long museoId) {
        return curadorService.asignarCuradorAMuseo(curadorId, museoId);
    }

    // Listar los museos que tiene un curador
    @GetMapping("/museos/{curadorId}")
    public Iterable<Museo> listarMuseosDeCurador(@PathVariable Long curadorId) {
        return curadorService.listarMuseosDeCurador(curadorId);
    }

    // Listar los curadores de un museo
    @GetMapping("/curadores/{museoId}")
    public Iterable<Curador> listarCuradoresDeMuseo(@PathVariable Long museoId) {
        return curadorService.listarCuradoresDeMuseo(museoId);
    }

    // Crear un nuevo curador
    @PostMapping
    public Curador crearCurador(@RequestBody Curador curador) {
        return curadorService.crearCurador(curador);
    }
}
