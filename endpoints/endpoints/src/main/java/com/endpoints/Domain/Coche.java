package com.endpoints.Domain;

import java.util.ArrayList;

public class Coche {
    private String matricula;
    private String modelo;
    private Propietario propietario;

    public Coche(String matricula, String modelo, Propietario propietario) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
