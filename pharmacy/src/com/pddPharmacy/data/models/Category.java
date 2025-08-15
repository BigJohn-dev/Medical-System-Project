package com.pddPharmacy.data.models;

public enum Category {
    SYRUP(1), TABLET(10), CAPSULE(5), IV(2);

    private int numberInPack;

    Category(int numberAdministered){
        this.numberInPack = numberAdministered;
    }

    public int getNumberInPack(){
        return numberInPack;
    }

    public void setNumberInPack(int numberInPack){
        this.numberInPack = numberInPack;
    }
}
