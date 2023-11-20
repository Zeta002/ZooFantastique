package net.zoofantastique.controller.enclosure;

public enum Cleanness {
    BAD("Mauvais"),
    CORRECT("Correct"),
    GOOD("Bon");

    // Attributs
    private String value;

    // Constructeur
    Cleanness(String cleenness) {
        this.value = cleenness;
    }

    // Méthodes
    public Cleanness deteriorate() {
        Cleanness[] cleannesses = Cleanness.values();
        int currentIndex = this.ordinal();
        if (currentIndex > 0) {
            return cleannesses[currentIndex - 1];
        } else {
            return this;
        }
    }

    public Cleanness clean() {
        Cleanness[] cleannesses = Cleanness.values();
        int currentIndex = this.ordinal();
        if (currentIndex < cleannesses.length - 1) {
            return cleannesses[currentIndex + 1];
        } else {
            return this;
        }
    }

    // Getter
    public String getValue() {
        return value;
    }
}
