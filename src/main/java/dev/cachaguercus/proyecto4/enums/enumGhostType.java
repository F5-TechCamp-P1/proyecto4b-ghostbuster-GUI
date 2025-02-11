package dev.cachaguercus.proyecto4.enums;

public enum enumGhostType {
    CLASE_I ("Manifestación menor"),
    CLASE_II ("Aparición móvil"),
    CLASE_III ("Entidad inteligente"),
    CLASE_IV ("Fantasma histórico"),
    CLASE_V ("Espíritu antropomorfo"),
    CLASE_VI ("Espíritu demoníaco"),
    CLASE_VII("Entidad ultraterrena");

    private final String ghostTypeDescription;

    private enumGhostType (String ghostTypeDescription) {
        this.ghostTypeDescription = ghostTypeDescription;
    }

    public String getGhostTypeDescription(){
        return ghostTypeDescription;
    }

}