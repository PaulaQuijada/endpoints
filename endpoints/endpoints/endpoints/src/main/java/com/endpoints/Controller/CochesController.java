package com.endpoints.Controller;

import com.endpoints.Domain.Coche;
import com.endpoints.Service.CarNotExistsException;
import com.endpoints.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CochesController {
    @Autowired
    private CarService carService;

    @GetMapping("/coches")
    public ResponseEntity<HashMap<String, Coche>> getCars() {
        return ResponseEntity.ok(carService.getCoches());
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
    public ResponseEntity updateCar(@PathVariable String matricula, @RequestBody CarUpdate car) {
        try {
            carService.updateCar(matricula, car);
            return ResponseEntity.ok().build();
        } catch (CarNotExistsException | EmptyFieldException | WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @GetMapping("/coches/{matricula}")
    public ResponseEntity<CarOutPutMatricula> buscarCoche(@PathVariable String matricula) {
        try {
            CarOutPutMatricula coche = carService.getCoche(matricula);
            return ResponseEntity.ok(coche);
        } catch (CarNotExistsException | WrongArgumentException | EmptyFieldException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}





