package net.zoofantastique.controller.consumable.behavior;

/**
 * Enum FoodType, représente le type de nourriture.
 */
public enum FoodType {
    TERRESTRIAL("Terrestre"),
    MARINE("Marin"),
    AERIAL("Aérien");

    // Attributs
    private final String value; // valeur de l'enum

    // Constructeur
    FoodType(String value) {
        this.value = value;
    }

    // Getter et setter

    public String getValue() {
        return value;
    }
}
