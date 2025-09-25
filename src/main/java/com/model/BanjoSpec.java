package com.model;

public class BanjoSpec {
    private int numStrings;
    private Boolean inevertedStrings;

    public BanjoSpec(int numStrings, Boolean inevertedStrings) {
        this.numStrings = numStrings;
        this.inevertedStrings = inevertedStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public Boolean getInevertedStrings() {
        return inevertedStrings;
    }

}
