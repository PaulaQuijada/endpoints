package com.endpoints.Domain;


import com.endpoints.Controller.CarInput;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private int year;


    public Coche(String matricula, String marca, String modelo, int year) {
        this.matricula = matricula;
        if (marca == null) this.marca = "no especificada";
        else this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public Coche(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = "C5";
        this.year = 2000;
    }
    public static Coche getCoche(CarInput carInput){
        return new Coche(carInput.getMatricula(), carInput.getModelo(), "C5", 2000);
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
