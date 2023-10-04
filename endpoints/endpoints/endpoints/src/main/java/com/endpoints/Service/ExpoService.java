package com.endpoints.Service;

import com.endpoints.Controller.*;
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
                if(cochesExpo == null){
                    cochesExpo= new ArrayList<>();
                }
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
    public ExpoOutPut getExposicion(int numExpo) throws NumExpoNotExistsException, WrongArgumentException {
        for(Exposicion exposicion : exposiciones){
            if(exposicion.getNumExpo() == numExpo)
                return new ExpoOutPut(numExpo);
        }
        throw new NumExpoNotExistsException("La exposición no existe");
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

    public ExpoOutPut updateExpo(int numExpo, ExpoUpdate expo) throws WrongArgumentException, EmptyFieldException, CarNotExistsException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == numExpo) {
                if(expo.getName() != null){
                    exposicion.setNameExpo(expo.getName());
                    return new ExpoOutPut(exposicion.getNumExpo(), expo.getName());
                }
            }
        }
        throw new CarNotExistsException("El coche no existe");
    }
}
