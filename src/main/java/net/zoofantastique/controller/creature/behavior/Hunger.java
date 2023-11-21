package net.zoofantastique.controller.creature.behavior;

public enum Hunger {
    SATISFIED("Répu", 10),
    MEDIUM("Moyen", 5),
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

    // Getter et Setter
    public String getState() {
        return state;
    }

    public int getHungerValue() {
        return value;
    }

    /**
     * Méthode pour définir la valeur de la faim de la créature.
     * Cette méthode met à jour la valeur de la faim et appelle ensuite la méthode updateHunger pour mettre à jour l'état de la faim en fonction de la nouvelle valeur.
     *
     * @param value La nouvelle valeur de la faim de la créature.
     */
    public void setValue(int value) {
        this.value = value;
        updateHunger();
    }

    /**
     * Méthode pour mettre à jour l'état de la faim de la créature en fonction de la valeur de la faim.
     * Si la valeur de la faim est supérieure ou égale à 10, l'état de la faim est défini sur "Répu".
     * Si la valeur de la faim est supérieure à 3 mais inférieure à 10, l'état de la faim est défini sur "Moyen".
     * Si la valeur de la faim est inférieure ou égale à 3, l'état de la faim est défini sur "Affamé(e)".
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
