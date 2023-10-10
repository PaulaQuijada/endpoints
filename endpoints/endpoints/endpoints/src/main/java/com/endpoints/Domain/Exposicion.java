package com.endpoints.Domain;


import com.endpoints.Controller.ExpoInput;
import com.endpoints.Controller.WrongArgumentException;

import java.util.HashMap;

public class Exposicion {
    private int numExpo;
    private String nameExpo;
    private HashMap<String, Coche> cochesExpo;

    public Exposicion(int numExpo, String nameExpo) {
        this.numExpo = numExpo;
        this.nameExpo = nameExpo;
        this.cochesExpo = new HashMap<>();
    }
public static Exposicion getExpo(ExpoInput expoInput){
        return new Exposicion(expoInput.getNumExpo(), expoInput.getName());
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

    public HashMap<String, Coche> getCochesExpo() {
        return cochesExpo;
    }

    public void setCochesExpo(HashMap<String, Coche> cochesExpo) {
        this.cochesExpo = cochesExpo;
    }

    public void addCoche(Coche coche){
        this.cochesExpo.put(coche.getMatricula(), coche);
    }
}
