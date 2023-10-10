package com.endpoints.Service;

import com.endpoints.Controller.*;
import com.endpoints.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CarService {
    private HashMap<String, Coche> coches = new HashMap<>();

    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public void addCar(CarInput carInput) throws AlreadyExistsException {
        if (coches.containsKey(carInput.getMatricula())) {
            throw new AlreadyExistsException("La matrícula ya existe");
        } else {
            coches.put(carInput.getMatricula(), Coche.getCoche(carInput));
        }
    }


    public void updateCar(String matricula, CarUpdate car) throws
            WrongArgumentException, EmptyFieldException, CarNotExistsException {
        for (Coche coche : coches.values()) {
            if (coche.getMatricula().equals(matricula)) {
                coche.setMarca(car.getMarca());
                coche.setYear(car.getYear());
                return;
            }
            throw new CarNotExistsException("El coche no existe");
        }
    }


    public CarOutPutMatricula getCoche(String matricula) throws
            CarNotExistsException, WrongArgumentException, EmptyFieldException {
        for (Coche coche : coches.values()) {
            if (coche.getMatricula().equals(matricula)) {
                return new CarOutPutMatricula(matricula);
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }
}
