package com.model;

public class BanjoSpec extends InstrumentSpec{
    private int nbrStrings;

    public BanjoSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int nbrStrings) {
        super(builder, model, type, backWood, topWood);
        this.nbrStrings = nbrStrings;
    }

    public int getNbrStrings() {
        return nbrStrings;
    }

    public boolean matches (InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (nbrStrings != ((BanjoSpec)otherSpec).nbrStrings)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "nbrStrings=" + nbrStrings +
                "} " + super.toString();
    }
}