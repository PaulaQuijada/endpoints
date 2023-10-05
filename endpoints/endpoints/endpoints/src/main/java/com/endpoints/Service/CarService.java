package com.endpoints.Service;

import com.endpoints.Controller.*;
import com.endpoints.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    private ArrayList<Coche> coches = new ArrayList<>();

    public void addCar(CarInput carInput) throws AlreadyExistsException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(carInput.getMatricula())) {
                throw new AlreadyExistsException("La matrícula ya existe");
            }
        }
        Coche coche = new Coche(carInput.getMatricula(), carInput.getModelo());
        coches.add(coche);
    }

    public ArrayList<Coche> getCars() throws WrongArgumentException, EmptyFieldException {
        return coches;
    }

    public void updateCar(String matricula, CarUpdate car) throws WrongArgumentException, EmptyFieldException, CarNotExistsException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                coche.setMarca(car.getMarca());
                coche.setYear(car.getYear());
                break;
            }
            if(coches.indexOf(coche)== coches.size()-1) throw new CarNotExistsException("El coche no existe");
        }
    }


    public CarOutPutMatricula getCoche(String matricula) throws CarNotExistsException, WrongArgumentException, EmptyFieldException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                return new CarOutPutMatricula(matricula);
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }
}
