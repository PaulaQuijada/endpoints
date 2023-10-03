package com.endpoints.Controller;

public class CarInput {
private String matricula;
private String modelo;
private String marca;


    public CarInput(String matricula, String modelo) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
        if(modelo == null) throw new EmptyFieldException("El modelo no puede estar vacío");
        this.modelo = modelo;
    }

    public CarInput(String matricula, String modelo, String marca) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
        if(modelo == null) throw new EmptyFieldException("El modelo no puede estar vacío");
        this.modelo = modelo;
        if(marca == null || marca.trim().length() <1) throw new EmptyFieldException("La marca no puede estar vacía");
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
