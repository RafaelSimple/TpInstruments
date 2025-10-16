package com.model;

public class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;
    private Instruments nomInstrument;
    private String nomInstrumentNom;
    
    public Instrument(String serialNumber, double price, InstrumentSpec spec, Instruments nomInstrument) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
        this.nomInstrument = nomInstrument;
    }

    // Constructeur de compatibilité (sans nomInstrument) conservé
    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this(serialNumber, price, spec, null);
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public double getPrice() {
        return price;
    }
    public InstrumentSpec getSpec() {
        return spec;
    }

    public Instruments getNomInstrument() {
        return nomInstrument;
    }

    public String getNomInstrumentNom() {
        return nomInstrumentNom;
    }

    public void setNomInstrumentNom(String nomInstrumentNom) {
        this.nomInstrumentNom = nomInstrumentNom;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", spec=" + spec +
                ", nomInstrument=" + (nomInstrument != null ? nomInstrument : "null") +
                ", nomInstrumentNom=" + (nomInstrumentNom != null ? nomInstrumentNom : "null") +
                '}';
    }

}
