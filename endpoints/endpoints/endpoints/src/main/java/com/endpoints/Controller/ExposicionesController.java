package com.endpoints.Controller;

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
        try {
            return ResponseEntity.ok(expoService.getExpo());
        } catch (WrongArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/exposiciones")
    public void addExpo(@RequestBody ExpoInput expo) {
        try {
            expoService.addExpo(expo);
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("exposiciones/{numExpo}")
    public ResponseEntity<ExpoOutPut> buscarExpo(@PathVariable int numExpo){
        try {
            ExpoOutPut expo = expoService.getExposicion(numExpo);
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
    public ResponseEntity<ExpoOutPut> updateExpo(@PathVariable int numExpo, @RequestBody ExpoUpdate expo) {
        try {
            return ResponseEntity.ok(expoService.updateExpo(numExpo, expo));
        } catch (CarNotExistsException | EmptyFieldException | WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @GetMapping("/exposiciones/{numExpo}/coches/{matricula}")
    public ResponseEntity<CarOutPut> cocheExpo(@PathVariable int numExpo, @PathVariable String matricula) {
        try {
            return ResponseEntity.ok(expoService.getCocheExpo(numExpo, matricula));
        } catch (CarNotExistsException | NumExpoNotExistsException | WrongArgumentException | EmptyFieldException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/exposiciones/{numExpo}/coches")
    public void addCocheExpo(@PathVariable int numExpo, @RequestBody CarInput carInput){
        try{
            expoService.addCocheExpo(numExpo, carInput);
        }
        catch (NumExpoNotExistsException e) {
            System.out.println(e.getMessage());
        }
    }
}




