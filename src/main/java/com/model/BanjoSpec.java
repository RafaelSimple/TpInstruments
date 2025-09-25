package com.model;

public class BanjoSpec extends InstrumentSpec {
    private int nbrStrings;
    private boolean invertedStrings;
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;

    public BanjoSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int nbrStrings, boolean invertedStrings) {
        super(builder, model, type, backWood, topWood);
        this.nbrStrings = nbrStrings;
        this.invertedStrings = invertedStrings;
    }

    public int getNbrStrings() {
        return nbrStrings;
    }

    public boolean isInvertedStrings() {
        return invertedStrings;
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
