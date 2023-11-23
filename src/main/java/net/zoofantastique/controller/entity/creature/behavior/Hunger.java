package net.zoofantastique.controller.entity.creature.behavior;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public enum Hunger {
    MAX("Répu", 10),
    SATISFIED("Satisfait", 9),
    MEDIUM("Moyen", 6),
    HUNGRY("Affamé(e)", 3);

    // Attributs

    // L'état de la faim de la créature, peut être "Répu", "Moyen" ou "Affamé(e)".
    private String state;
    // La valeur numérique de la faim de la créature, utilisée pour déterminer l'état de la faim.
    private int value;

    // Constructeur
    Hunger(String state, int value) {
        this.state = state;
        this.value = value;
    }

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

    // Getter
    public String getState() {
        return state;
    }

    public int getValue() {
        return value;
    }

}
