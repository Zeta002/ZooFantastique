package net.zoofantastique.controller.creature.consumable.behavior;

public enum FoodType {
    TERRESTRIAL("Terrestre"),
    MARINE("Marin"),
    AERIAL("Aérien");

    // Atrributs
    private final String value;

    // Constructeur
    FoodType(String value) {
        this.value = value;
    }

    // Getter
    public String getValue() {
        return value;
    }
}
