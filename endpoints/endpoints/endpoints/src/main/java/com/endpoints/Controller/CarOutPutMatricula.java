package com.endpoints.Controller;

public class CarOutPutMatricula {
    private String matricula;

    public CarOutPutMatricula(String matricula) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null || matricula.isEmpty()) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
