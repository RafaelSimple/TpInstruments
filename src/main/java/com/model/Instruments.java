package com.model;

public enum Instruments {
    GUITAR,MANDOLIN ,BANJO;
    
    @Override
    public String toString() {
        switch(this) {
            case GUITAR: return "Guitar";
            case MANDOLIN: return "Mandolin";
            case BANJO: return "Banjo";
            default: return "Intrusment inconnu";
        }
    }


}
