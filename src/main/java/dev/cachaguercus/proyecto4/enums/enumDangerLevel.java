package dev.cachaguercus.proyecto4.enums;

public enum enumDangerLevel {

    BAJO(1),
    MEDIO(2),
    ALTO(3),
    CRITICO(4);

    private final int numericLevel;

    enumDangerLevel(int numericLevel) {
        this.numericLevel = numericLevel;
    }

    public int getNumericLevel() {
        return numericLevel;
    }

}
