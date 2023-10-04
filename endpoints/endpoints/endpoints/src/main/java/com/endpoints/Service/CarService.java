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
        Coche coche = new Coche(carInput.getMatricula(), "Citroen", carInput.getModelo(), 2000);
        coches.add(coche);
    }

    public ArrayList<CarOutPut> getCars() throws WrongArgumentException, EmptyFieldException {
        ArrayList<CarOutPut> cars = new ArrayList<>();
        for (Coche coche : coches) {
            cars.add(new CarOutPut(coche.getMatricula(), coche.getMarca(), coche.getModelo(), coche.getYear()));
        }
        return cars;
    }

    public CarOutPut updateCar(String matricula, CarUpdate car) throws WrongArgumentException, EmptyFieldException, CarNotExistsException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                if (car.getMarca() != null) {
                    coche.setMarca(car.getMarca());
                }
                if (car.getYear() != 0) {
                    coche.setYear(car.getYear());
                }
                return new CarOutPut(coche.getMatricula(), coche.getMarca(), coche.getModelo(), coche.getYear());
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }

    public CarOutPut getCoche(String matricula) throws CarNotExistsException, WrongArgumentException, EmptyFieldException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                return new CarOutPut(matricula);
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }
}
