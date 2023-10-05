package com.endpoints.Domain;

import com.endpoints.Controller.CarInput;

import java.util.ArrayList;

public class Exposicion {
    private int numExpo;
    private String nameExpo;
    private ArrayList<Coche> cochesExpo;

    public Exposicion(int numExpo, String nameExpo) {
        this.numExpo = numExpo;
        this.nameExpo = nameExpo;
        this.cochesExpo = new ArrayList<>();
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

    public ArrayList<Coche> getCochesExpo() {
        return cochesExpo;
    }

    public void setCochesExpo(ArrayList<Coche> cochesExpo) {
        this.cochesExpo = cochesExpo;
    }
    public void addCoche(Coche coche){
        this.cochesExpo.add(coche);
    }
}
