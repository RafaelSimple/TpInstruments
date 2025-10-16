package com.model;

public class MandolinSpec extends InstrumentSpec {
    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Style style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public boolean matches (InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof MandolinSpec))
            return false;
            
        if (!super.matches(otherSpec))
            return false;
        if (style != ((MandolinSpec)otherSpec).style)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MandolinSpec{" +
                "style=" + style +
                "} " + super.toString();
    }

}
