package com.endpoints.Service;

import com.endpoints.Controller.*;
import com.endpoints.Domain.Coche;
import com.endpoints.Domain.Exposicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ExpoService {
    private HashMap<Integer, Exposicion> exposiciones = new HashMap<>();
    @Autowired
    private CarService carService;

    public void addExpo(ExpoInput expoInput) throws AlreadyExistsException, WrongArgumentException {
        if (exposiciones.containsKey(expoInput.getNumExpo())) {
            throw new AlreadyExistsException("La exposición ya existe");
        } else {
            exposiciones.put(expoInput.getNumExpo(), Exposicion.getExpo(expoInput));
        }
    }


    public void addCocheExpo(int numExpo, String matricula) throws NumExpoNotExistsException, WrongArgumentException, EmptyFieldException, CarNotExistsException {

        if (exposiciones.containsKey(numExpo)) {
            Exposicion exposicion = exposiciones.get(numExpo);
            HashMap<String, Coche> coches = carService.getCoches();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                exposicion.addCoche(coche);
                coches.remove(matricula);
                carService.setCoches(coches);

            }
            else throw new CarNotExistsException("El coche no existe");
        }
       else throw new NumExpoNotExistsException("La exposición no existe");
    }


    public ArrayList<ExpoOutPut> getExpo() throws WrongArgumentException {
        ArrayList<ExpoOutPut> expos = new ArrayList<>();
        for (Exposicion exposicion : exposiciones.values()) {
            expos.add(new ExpoOutPut(exposicion.getNumExpo()));
        }
        return expos;
    }

    public Exposicion getExposicion(int numExpo) throws NumExpoNotExistsException, WrongArgumentException {
        for (Exposicion exposicion : exposiciones.values()) {
            if (exposicion.getNumExpo() == numExpo)
                return exposicion;
        }
        throw new NumExpoNotExistsException("La exposición no existe");
    }

    public CarOutPut getCocheExpo(int numExpo, String matricula) throws NumExpoNotExistsException, CarNotExistsException, WrongArgumentException, EmptyFieldException {
        if (exposiciones.containsKey(numExpo)) {
            HashMap<String, Coche> coches = carService.getCoches();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                return CarOutPut.getCoche(coche);
            }
            throw new CarNotExistsException("El coche no existe");
        }
        throw new NumExpoNotExistsException("El número de exposición no existe");

    }


    public void updateExpo(int numExpo, ExpoUpdate expo) throws WrongArgumentException, EmptyFieldException, NumExpoNotExistsException {
        if (exposiciones.containsKey(numExpo)) {
            Exposicion exposicion = exposiciones.get(numExpo);
            exposicion.setNameExpo(expo.getName());

        }
        throw new NumExpoNotExistsException("La exposición no existe");

    }

}

