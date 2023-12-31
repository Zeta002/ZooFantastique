package net.zoofantastique.controller.enclosure.behavior;

/**
 * Enum Cleanness, représente le niveau de propreté de l'enclos.
 */
public enum Cleanness {
    BAD("Mauvais"),
    CORRECT("Correct"),
    GOOD("Bon");

    // Attributs
    private final String value; // valeur de l'enum

    // Constructeur
    Cleanness(String cleanness) {
        this.value = cleanness;
    }

    // Méthodes

    /**
     * Méthode pour nettoyer l'enclos.
     * Cette méthode augmente le niveau de propreté de l'enclos d'un cran, à moins que l'enclos soit déjà au niveau de propreté le plus élevé, auquel cas le niveau de propreté reste inchangé.
     *
     * @return Le nouveau niveau de propreté de l'enclos.
     */
    public Cleanness clean() {
        Cleanness[] cleannesses = Cleanness.values();
        int currentIndex = this.ordinal();
        if (currentIndex < cleannesses.length - 1) {
            return cleannesses[currentIndex + 1];
        } else {
            return this;
        }
    }

    /**
     * Méthode pour détériorer la propreté de l'enclos.
     * Cette méthode diminue le niveau de propreté de l'enclos d'un cran, à moins que l'enclos soit déjà au niveau de propreté le plus bas, auquel cas le niveau de propreté reste inchangé.
     *
     * @return Le nouveau niveau de propreté de l'enclos.
     */
    public Cleanness deteriorate() {
        Cleanness[] cleannesses = Cleanness.values();
        int currentIndex = this.ordinal();
        if (currentIndex > 0) {
            return cleannesses[currentIndex - 1];
        } else {
            return this;
        }
    }

    // Getter et setter

    public String getValue() {
        return value;
    }
}
