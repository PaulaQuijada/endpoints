package com.endpoints.Controller;

public class CarUpdate {
    private String marca;
    private int year;

    public CarUpdate(String marca, int year) throws EmptyFieldException, WrongArgumentException {
        if(marca == null || marca.trim().length() <1) throw new EmptyFieldException("La marca no puede estar vacía");
        this.marca = marca;
        if(year <0) throw new WrongArgumentException("El año no puede ser menor a 0");
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
