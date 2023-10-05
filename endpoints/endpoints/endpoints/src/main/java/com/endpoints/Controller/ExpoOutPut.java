package com.endpoints.Controller;

public class ExpoOutPut {
    private int numExpo;

    public ExpoOutPut(int numExpo) throws WrongArgumentException {
        if(numExpo <=0) throw new WrongArgumentException("El número de exposición no puede ser menor o igual que 0");
        this.numExpo = numExpo;
    }
    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }
}
