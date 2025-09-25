package com.model;

public class GuitarSpec extends InstrumentSpec {

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int nbrStrings) {
        super(builder, model, type, backWood, topWood);
        this.nbrStrings = nbrStrings;
    }

    public int getNbrStrings() {
        return nbrStrings;
    }

}
