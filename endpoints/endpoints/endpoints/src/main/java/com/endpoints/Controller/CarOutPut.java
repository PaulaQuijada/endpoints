package com.endpoints.Controller;

import com.endpoints.Domain.Coche;

public class CarOutPut {
    private String matricula;
    private String marca;


    public CarOutPut(String matricula, String marca) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null || matricula.isEmpty()) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
        if(marca == null || marca.trim().length() <1) throw new EmptyFieldException("La marca no puede estar vacía");
        this.marca = marca;
    }
public static CarOutPut getCoche(Coche coche) throws WrongArgumentException, EmptyFieldException {
        return new CarOutPut(coche.getMatricula(), coche.getMarca());
}
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
