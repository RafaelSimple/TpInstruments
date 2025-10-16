package com.model;

public class InstrumentFactory {
    public Instrument createInstrument(String type, String serialNumber, double price, InstrumentSpec spec) {
        switch (type.toLowerCase()) {
            case "guitar":
                return new Guitar(serialNumber, price, (GuitarSpec) spec);
            case "banjo":
                return new Banjo(serialNumber, price, (BanjoSpec) spec);
            case "mandolin":
                return new Mandolin(serialNumber, price, (MandolinSpec) spec);
            default:
                throw new IllegalArgumentException("instrument incconu");
        }
    }

}
