package com.model;

public enum Wood {
    ADIRONDACK, ALDER, BRAZILIAN_ROSEWOOD, CEDAR, COCOBOLO, INDIAN_ROSEWOOD, MAHOGANY, MAPLE, SITKA, ANY;

    @Override
    public String toString() {
        switch(this) {
            case ADIRONDACK: return "Adirondack";
            case ALDER:      return "Alder";
            case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
            case INDIAN_ROSEWOOD:   return "Indian Rosewood";
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
