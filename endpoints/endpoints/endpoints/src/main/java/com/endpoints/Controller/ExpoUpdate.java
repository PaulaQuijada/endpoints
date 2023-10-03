package com.endpoints.Controller;

public class ExpoUpdate {
    private String name;

    public ExpoUpdate(String name) throws WrongArgumentException {
        if(name.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (name == null || name.trim().length() <1) throw new WrongArgumentException("El nombre y el apellido no puede estar vacío");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
