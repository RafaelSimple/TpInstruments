package com.model;

public class GuitarSpec extends InstrumentSpec {
    private int nbrStrings;
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int nbrStrings) {
        super(builder, model, type, backWood, topWood);
        this.nbrStrings = nbrStrings;
    }

    public int getNbrStrings() {
        return nbrStrings;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }


}
