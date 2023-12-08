package net.zoofantastique.controller.entity.creature.behavior;

import org.jetbrains.annotations.Nullable;

/**
 * Enumération Hunger représentant la faim d'une créature.
 */
public enum Hunger {
    MAX("Répu", 10),
    SATISFIED("Satisfait", 9),
    MEDIUM("Moyen", 6),
    HUNGRY("Affamé(e)", 3);

    // Attributs
    private final String state; // L'état de la faim de la créature
    private final int value; // La valeur de la faim de la créature

    // Constructeur
    Hunger(String state, int value) {
        this.state = state;
        this.value = value;
    }

    // Méthodes

    @Nullable
    public static String getStateFromValue(int value) {
        Hunger[] states = Hunger.values();
        for (int i = states.length-1 ; i >= 0 ; i--) {
            if (value <= states[i].getValue()) {
                return states[i].state;
            }
        }
        return null;
    }

    // Getter et setter

    public String getState() {
        return state;
    }

    public int getValue() {
        return value;
    }
}
