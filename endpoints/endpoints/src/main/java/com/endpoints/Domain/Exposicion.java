package com.endpoints.Domain;

import java.util.ArrayList;

public class Exposicion {
    private int numExpo;
    private ArrayList<Coche> cochesExpo;

    public Exposicion(int numExpo, ArrayList<Coche> cochesExpo) {
        this.numExpo = numExpo;
        this.cochesExpo = cochesExpo;
    }

    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }

    public ArrayList<Coche> getCochesExpo() {
        return cochesExpo;
    }

    public void setCochesExpo(ArrayList<Coche> cochesExpo) {
        this.cochesExpo = cochesExpo;
    }
    public void addCoche(Coche coche){
        cochesExpo.add(coche);
    }
}
