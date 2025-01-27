package com.microservicioMuseo.Controller;

import com.microservicioMuseo.Model.Museo;
import com.microservicioMuseo.Service.MuseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/museos")
public class MuseoController {

    @Autowired
    private MuseoService museoService;

    @GetMapping
    public List<Museo> obtenerMuseos() {
        return museoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Museo> obtenerMuseo(@PathVariable Long id) {
        Optional<Museo> museo = museoService.obtenerPorId(id);
        return museo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Museo> crearMuseo(@RequestBody Museo museo) {
        Museo nuevoMuseo = museoService.guardar(museo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMuseo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMuseo(@PathVariable Long id) {
        museoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}