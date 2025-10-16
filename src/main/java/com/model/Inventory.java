package com.model;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List instruments;

    public Inventory(){
    instruments = new LinkedList();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument)i.next();
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List search(InstrumentSpec searchSpec) {
        List matchingInstruments = new LinkedList();
        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument)i.next();
            if (instrument.getSpec().matches(searchSpec))
                matchingInstruments.add(instrument);
        }
        return matchingInstruments;
    }


}
