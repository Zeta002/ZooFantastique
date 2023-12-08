package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Enumération Age représentant l'âge d'une créature.
 */
public enum Age {
    BABY("Bébé", 0.1),
    CHILD("Enfant", 0.5),
    ADULT("Adulte", 1),
    OLD("Vieux", 0.5),
    DEAD("Mort", 0);

    // Attributs
    private final String value; // Valeur de l'âge
    private final double agePowerFactor; // Facteur de puissance de l'âge (utilisé pour les lycanthropes)

    // Constructeur
    Age(String value, double agePowerFactor) {
        this.value = value;
        this.agePowerFactor = agePowerFactor;
    }

    // Méthodes

    /**
     * Méthode pour obtenir l'âge suivant d'une créature.
     * Cette méthode renvoie l'âge suivant dans l'énumération Age, à moins que la créature soit déjà à l'âge le plus élevé (DEAD), auquel cas l'âge reste inchangé.
     *
     * @return Le nouvel âge de la créature.
     */
    public Age nextAge() {
        Age[] ages = Age.values();
        int currentIndex = this.ordinal();
        if (currentIndex < ages.length - 1) {
            return ages[currentIndex + 1];
        } else {
            return this;
        }
    }

    // Getter et setter

    public String getValue() {
        return this.value;
    }

    public double getAgePowerFactor() { return this.agePowerFactor; }
}
