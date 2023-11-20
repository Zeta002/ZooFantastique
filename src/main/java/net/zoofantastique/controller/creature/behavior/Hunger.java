package net.zoofantastique.controller.creature.behavior;

public enum Hunger {
    SATISFIED("Répu", 10),
    MEDIUM("Moyen", 5),
    HUNGRY("Affamé(e)", 3);

    // Attributs
    private String state;
    private int value;

    // Constructeur
    Hunger(String state, int value) {
        this.state = state;
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public int getValue() {
        return value;
        // TODO : à refaire
    }

    /**
     * Setter de l'enum en lui même et
     * de la valeur de la faim
     *
     * @author Quentin B.
     * @author Angelo P.
     * @param value valeur de la faim
     */
    public void setValue(int value) {
        if (value <= HUNGRY.value) {
            this.state = HUNGRY.state;
        } else if(value <= MEDIUM.value) {
            this.state = MEDIUM.state;
        } else {
            this.state = SATISFIED.state;
        }
        this.value = value;
        // TODO : à refaire
    }
}
