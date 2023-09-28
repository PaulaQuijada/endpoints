package com.endpoints.CochesController;

import com.endpoints.Domain.Coche;
import com.endpoints.Domain.Exposicion;
import com.endpoints.Domain.Propietario;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CochesController {
    private List<Coche> coches = new ArrayList<>();
    private List<Propietario> propietarios = new ArrayList<>();

    @GetMapping("/coches")
    public List<Coche> listarCoches() {
        return coches;
    }

    @PostMapping("/coches")
    public void addCoche(@RequestBody Coche c) {
        coches.add(c);
    }

    @GetMapping("/coches/{posicion}")
    public ResponseEntity<Coche> buscarCoche(@PathVariable int posicion) {
        if (posicion > 0 && posicion <= coches.size()) {
            Coche cocheX = coches.get(posicion - 1);
            return ResponseEntity.ok(cocheX);
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping("/coches/{posicion}/propietarios")
    public ResponseEntity<Propietario> buscarPropietarios(@PathVariable int posicion) {
        if (posicion > 0 && posicion <= coches.size()) {
            Coche coche = coches.get(posicion - 1);
            Propietario propietario = coche.getPropietario();
            return ResponseEntity.ok(propietario);
        } else return ResponseEntity.notFound().build();
    }
    @PostMapping("/coches/{posicion}/propietarios")
    public ResponseEntity addPropietario(@PathVariable int posicion, @RequestBody Propietario propietario){
            if (posicion > 0 && posicion <= coches.size()) {
                Coche coche = coches.get(posicion - 1);
                coche.setPropietario(propietario);
                return ResponseEntity.ok(null);
            } else return ResponseEntity.notFound().build();
        }
    }





