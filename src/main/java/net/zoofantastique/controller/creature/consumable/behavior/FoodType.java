package net.zoofantastique.controller.creature.consumable.behavior;

public enum FoodType {
    TERRESTRIAL("Terrestre"),
    MARINE("Marin"),
    AERIAL("Aérien");

    // Attributs
    // valeur du type d'aliment en français
    private final String value;

    // Constructeur
    FoodType(String value) {
        this.value = value;
    }

    // Getter

    /**
     * getter de la valeur du type, qui est
     * la traduction français pour l'affichage
     *
     * @author Angelo P.
     * @return valeur du type d'aliment en français
     */
    public String getValue() {
        return value;
    }
}
