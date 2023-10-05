package com.endpoints.Controller;

import com.endpoints.Domain.Exposicion;
import com.endpoints.Service.CarNotExistsException;
import com.endpoints.Service.ExpoService;
import com.endpoints.Service.NumExpoNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ExposicionesController {
    @Autowired
    private ExpoService expoService;

    @GetMapping("/exposiciones")
    public ResponseEntity<ArrayList<ExpoOutPut>> getExpo() {
       try{
           return ResponseEntity.ok(expoService.getExpo());
        }
        catch (WrongArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/exposiciones")
    public ResponseEntity addExpo(@RequestBody ExpoInput expo) {
        try {
            expoService.addExpo(expo);
            return ResponseEntity.ok().build();
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("exposiciones/{numExpo}")
    public ResponseEntity<Exposicion> buscarExpo(@PathVariable int numExpo){
        try {
            Exposicion expo = expoService.getExposicion(numExpo);
            return ResponseEntity.ok(expo);
        } catch (NumExpoNotExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (WrongArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/exposiciones/{numExpo}")
    public ResponseEntity updateExpo(@PathVariable int numExpo, @RequestBody ExpoUpdate expo) {
        try {
            expoService.updateExpo(numExpo, expo);
            return ResponseEntity.ok().build();
        } catch (CarNotExistsException | EmptyFieldException | WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/exposiciones/{numExpo}/coches/{matricula}")
    public ResponseEntity<CarOutPut> cocheExpo(@PathVariable int numExpo, @PathVariable String matricula) {
        try {
            return ResponseEntity.ok(expoService.getCocheExpo(numExpo, matricula));
        } catch (CarNotExistsException | WrongArgumentException | EmptyFieldException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (NumExpoNotExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/exposiciones/{numExpo}/coches")
    public ResponseEntity addCocheExpo(@PathVariable int numExpo, @RequestBody CarInput carInput){
        try{
            expoService.addCocheExpo(numExpo, carInput);
            return ResponseEntity.ok().build();
        }
        catch (NumExpoNotExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}




