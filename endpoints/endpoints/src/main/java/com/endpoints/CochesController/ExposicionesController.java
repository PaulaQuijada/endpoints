package com.endpoints.CochesController;

import com.endpoints.Domain.Coche;
import com.endpoints.Domain.Exposicion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ExposicionesController {
    private List<Exposicion> exposiciones = new ArrayList<>();

    @GetMapping("/exposiciones")
    public List<Exposicion> listarExposiciones() {
        return exposiciones;
    }

    @PostMapping("/exposiciones")
    public void addExpo(@RequestBody Exposicion e) {
        exposiciones.add(e);
    }

    @GetMapping("exposiciones/{posicion}")
    public ResponseEntity<Exposicion> buscarExpo(@PathVariable int posicion) {
        if (posicion > 0 && posicion <= exposiciones.size()) {
            Exposicion exposicion = exposiciones.get(posicion - 1);
            return ResponseEntity.ok(exposicion);
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping("/exposiciones/{posicion}/coches")
    public ResponseEntity<ArrayList<Coche>> listarCochesExpo(@PathVariable int posicion) {
        if (posicion > 0 && posicion <= exposiciones.size()) {
            Exposicion exposicion = exposiciones.get(posicion - 1);
            return ResponseEntity.ok(exposicion.getCochesExpo());
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping("/exposiciones/{posicion}/coches")
    public ResponseEntity addCocheExpo(@PathVariable int posicion, @RequestBody Coche coche) {
        if (posicion > 0 && posicion <= exposiciones.size()) {
            Exposicion exposicion = exposiciones.get(posicion - 1);
            exposicion.addCoche(coche);
            return ResponseEntity.ok(null);
        } else return ResponseEntity.notFound().build();
    }
    @GetMapping("/exposiciones/{numExpo}/coches/{posicion}")
    public ResponseEntity<Coche> cocheExpo(@PathVariable int posicion, @PathVariable int numExpo){
        if(numExpo > 0 && numExpo <= exposiciones.size()){
            Exposicion exposicion = exposiciones.get(numExpo -1);
            if(posicion > 0 && posicion <= exposicion.getCochesExpo().size()){
                Coche coche = exposicion.getCochesExpo().get(posicion -1);
                return ResponseEntity.ok(coche);
            } else return ResponseEntity.notFound().build();
        } else return ResponseEntity.notFound().build();
    }

}



