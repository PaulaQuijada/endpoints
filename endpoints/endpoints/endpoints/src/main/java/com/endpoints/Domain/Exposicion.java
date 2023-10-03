package com.endpoints.Domain;

import com.endpoints.Controller.CarInput;

import java.util.ArrayList;

public class Exposicion {
    private int numExpo;
    private String nameExpo;
    private ArrayList<CarInput> cochesExpo;

    public Exposicion(int numExpo, String nameExpo) {
        this.numExpo = numExpo;
        this.nameExpo = nameExpo;
    }

    public Exposicion(int numExpo, String nameExpo, ArrayList<CarInput> cochesExpo) {
        this.numExpo = numExpo;
        this.nameExpo = nameExpo;
        this.cochesExpo = cochesExpo;
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

    public ArrayList<CarInput> getCochesExpo() {
        return cochesExpo;
    }

    public void setCochesExpo(ArrayList<CarInput> cochesExpo) {
        this.cochesExpo = cochesExpo;
    }
}
