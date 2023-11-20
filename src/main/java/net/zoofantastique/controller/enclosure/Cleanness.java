package net.zoofantastique.controller.enclosure;

public enum Cleanness {
    BAD("Mauvais"),
    CORRECT("Correct"),
    GOOD("Bon");

    // Attributs
    private String cleenness;

    // Constructeur
    Cleanness(String cleenness) {
        this.cleenness = cleenness;
    }

    public String getCleenness() {
        return cleenness;
    }
}
