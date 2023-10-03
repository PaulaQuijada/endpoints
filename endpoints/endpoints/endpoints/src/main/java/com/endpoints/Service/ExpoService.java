package com.endpoints.Service;

import com.endpoints.Controller.*;
import com.endpoints.Domain.Coche;
import com.endpoints.Domain.Exposicion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExpoService {
    private ArrayList<Exposicion> exposiciones = new ArrayList<>();

    public void addExpo(ExpoInput expo) throws AlreadyExistsException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == expo.getNumExpo()) {
                throw new AlreadyExistsException("La exposición ya existe");
            }
        }
        Exposicion exposicion = new Exposicion(expo.getNumExpo(), "1");
        exposiciones.add(exposicion);
    }

    public void addCocheExpo(int numExpo, CarInput carInput) throws NumExpoNotExistsException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == numExpo) {
                ArrayList<CarInput> cochesExpo = exposicion.getCochesExpo();
                cochesExpo.add(carInput);
                exposicion.setCochesExpo(cochesExpo);
            }
        } throw new NumExpoNotExistsException("La exposición no existe");
    }

    public ArrayList<ExpoOutPut> getExpo() throws WrongArgumentException {
        ArrayList<ExpoOutPut> expos = new ArrayList<>();
        for (Exposicion exposicion : exposiciones) {
            expos.add(new ExpoOutPut(exposicion.getNumExpo()));
        }
        return expos;
    }

    public CarOutPut getCocheExpo(int numExpo, String matricula) throws NumExpoNotExistsException, CarNotExistsException, WrongArgumentException, EmptyFieldException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == numExpo) {
                for (CarInput coche : exposicion.getCochesExpo()) {
                    if (coche.getMatricula().equals(matricula)) {
                        return new CarOutPut(matricula, coche.getMarca());
                    }
                }
                throw new CarNotExistsException("El coche no existe");
            }
        }
        throw new NumExpoNotExistsException("El número de exposición no existe");
    }

    public ExpoOutPut updateExpo(String name, ExpoUpdate expo) throws WrongArgumentException, EmptyFieldException, CarNotExistsException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNameExpo().equals(expo.getName())) {
                expo.setName("AAA");
                return new ExpoOutPut(exposicion.getNumExpo(), expo.getName());
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }
}