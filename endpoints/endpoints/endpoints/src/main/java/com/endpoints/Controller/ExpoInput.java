package com.endpoints.Controller;

public class ExpoInput {
    private int numExpo;
    private String name;

    public ExpoInput(int numExpo, String name) throws WrongArgumentException {
        if(numExpo <=0) throw new WrongArgumentException("El número de exposición no puede ser menor o igual que 0");
        this.numExpo = numExpo;
        if(name.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (name == null || name.trim().isEmpty()) throw new WrongArgumentException("El nombre y el apellido no puede estar vacío");
        this.name = name;
    }

    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
