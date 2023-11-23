package net.zoofantastique.controller.consumable.behavior;

public enum FoodType {
    TERRESTRIAL("Terrestre"),
    MARINE("Marin"),
    AERIAL("Aérien");

    // Attributs
    // La valeur de l'énumération FoodType, qui représente le type de nourriture.
    private final String value;

    // Constructeur
    FoodType(String value) {
        this.value = value;
    }

    // Getter et setter
    public String getValue() {
        return value;
    }
}
