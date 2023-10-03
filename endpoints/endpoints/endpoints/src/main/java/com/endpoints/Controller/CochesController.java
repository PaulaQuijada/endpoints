package com.endpoints.Controller;

import com.endpoints.Domain.Coche;
import com.endpoints.Service.CarNotExistsException;
import com.endpoints.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CochesController {
    @Autowired
    private CarService carService;

    @GetMapping("/coches")
    public ResponseEntity<ArrayList<CarOutPut>> getCars() {
        try {
            return ResponseEntity.ok(carService.getCars());
        } catch (WrongArgumentException | EmptyFieldException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/coches")
    public void addCoche(@RequestBody CarInput coche) {
        try {
            carService.addCar(coche);
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/coches/{matricula}")
    public ResponseEntity<CarOutPut> updateCar(@PathVariable String marca, int year, @RequestBody CarUpdate car) {
        try {
            return ResponseEntity.ok(carService.updateCar(marca, year, car));
        } catch (CarNotExistsException | EmptyFieldException | WrongArgumentException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @GetMapping("/coches/{matricula}")
    public ResponseEntity<CarOutPut> buscarCoche(@PathVariable String matricula) {
        try {
            return ResponseEntity.ok(carService.getCoche(matricula));
        } catch (CarNotExistsException | WrongArgumentException | EmptyFieldException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}





