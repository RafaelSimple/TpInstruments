package com.model;

public class Guitar {
    private GuitarSpec spec;
    
    public Guitar(GuitarSpec spec) {
        this.spec = spec;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

}
