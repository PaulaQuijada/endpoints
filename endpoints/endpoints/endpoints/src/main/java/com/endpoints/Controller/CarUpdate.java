package com.endpoints.Controller;

public class CarUpdate {
    private String marca;
    private int year;

    public CarUpdate(String marca, int year) {
        this.marca = marca;
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
