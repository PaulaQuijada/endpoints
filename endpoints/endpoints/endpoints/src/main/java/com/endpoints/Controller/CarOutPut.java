package com.endpoints.Controller;

public class CarOutPut {
    private String matricula;
    private String marca;
    private String modelo;
    private int year;


    public CarOutPut(String matricula, String marca, String modelo, int year) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null || matricula.isEmpty()) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
        if(marca == null || marca.trim().length() <1) throw new EmptyFieldException("El marca no puede estar vacío");
        this.marca = marca;
        if(modelo == null || modelo.trim().length() <1) throw new EmptyFieldException("El modelo no puede estar vacío");
        this.modelo = modelo;
        if(year <1000 || year >9999) throw new WrongArgumentException("El año no puede ser menor o mayor a 4 cifras");
        this.year = year;
    }

    public CarOutPut(String matricula) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null || matricula.isEmpty()) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
    }

    public CarOutPut(String matricula, String marca) throws EmptyFieldException, WrongArgumentException {
        if(matricula == null || matricula.isEmpty()) throw new EmptyFieldException("La matrícula no puede estar vacía");
        if(matricula.trim().length()<1 && matricula.length() >7) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new WrongArgumentException("La matrícula debe tener cuatro números y tres letras mayúsculas");
        this.matricula = matricula;
        if(marca == null || marca.trim().length() <1) throw new EmptyFieldException("La marca no puede estar vacía");
        this.marca = marca;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
