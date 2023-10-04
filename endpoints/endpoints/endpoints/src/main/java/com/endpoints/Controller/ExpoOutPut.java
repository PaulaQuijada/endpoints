package com.endpoints.Controller;

public class ExpoOutPut {
    private int numExpo;
    private String nameExpo;

    public ExpoOutPut() {
    }

    public ExpoOutPut(int numExpo) throws WrongArgumentException {
        if(numExpo <=0) throw new WrongArgumentException("El número de exposición no puede ser menor o igual que 0");
        this.numExpo = numExpo;
    }

    public ExpoOutPut(int numExpo, String nameExpo) throws WrongArgumentException {
        if(numExpo <=0) throw new WrongArgumentException("El número de exposición no puede ser menor o igual que 0");
        this.numExpo = numExpo;
        if(nameExpo.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (nameExpo == null || nameExpo.trim().isEmpty()) throw new WrongArgumentException("El nombre y el apellido no puede estar vacío");
        this.nameExpo = nameExpo;
    }


    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }

    public String getNameExpo() {
        return nameExpo;
    }

    public void setNameExpo(String nameExpo) {
        this.nameExpo = nameExpo;
    }
}
