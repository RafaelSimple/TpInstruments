package com.model;

public enum Wood {
    ADIRONDACK, CEDAR, COCOBOLO, MAHOGANY, MAPLE, SITKA, ANY;

    @Override
    public String toString() {
        switch(this) {
            case ADIRONDACK: return "Adirondack";
            case CEDAR:      return "Cedar";
            case COCOBOLO:   return "Cocobolo";
            case MAHOGANY:   return "Mahogany";
            case MAPLE:      return "Maple";
            case SITKA:      return "Sitka";
            case ANY:        return "Any";
            default:         return "Inconnu";
        }
    }

}
