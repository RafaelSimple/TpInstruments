package com.model;

public class GuitarSpec extends InstrumentSpec {
    private int nbrStrings;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int nbrStrings) {
        super(builder, model, type, backWood, topWood);
        this.nbrStrings = nbrStrings;
    }

    public int getNbrStrings() {
        return nbrStrings;
    }

    public boolean matches (InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof GuitarSpec))
            return false;

        if (nbrStrings != ((GuitarSpec)otherSpec).nbrStrings)
            return false;
        if (!super.matches(otherSpec))
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
