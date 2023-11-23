package net.zoofantastique.controller.entity.creature.behavior;

public enum Age {
    BABY("Bébé"),
    CHILD("Enfant"),
    ADULT("Adulte"),
    OLD("Vieux"),
    DEAD("Mort");

    // Attributs
    private final String value;

    // Constructeur
    Age(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

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
}
