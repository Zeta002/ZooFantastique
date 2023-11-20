package net.zoofantastique.controller.creature.behavior;

public enum Hunger {
    SATISFIED("Répu", 10),
    MEDIUM("Moyen", 5),
    HUNGRY("Affamé(e)", 3);

    // Attributs
    // Etat de la faim en français
    private String state;
    // Valeur de la faim
    private int value;

    // Constructeur
    Hunger(String state, int value) {
        this.state = state;
        this.value = value;
    }

    // Getter et Setter
    public String getState() {
        return state;
    }

    public int getHungerValue() {
        return value;
    }

    /**
     * Setter de la valeur de la faim, met à jour l'enum
     * en appellant la méthode updateHunger()
     *
     * @author Angelo P.
     * @param value valeur de la faim
     */
    public void setValue(int value) {
        this.value = value;
        updateHunger();
    }

    /**
     * Met à jour l'état de l'enum en fonction
     * de la valeur de la faim
     *
     * @author Quentin B.
     * @author Angelo P.
     */
    public void updateHunger() {
        if (this.value >= 10) {
            this.state = "Répu";
        } else if (value > 3) {
            this.state = "Moyen";
        } else {
            this.state = "Affamé(e)";
        }
    }
}
