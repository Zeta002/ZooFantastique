package net.zoofantastique.controller.enclosure.behavior;

/**
 * Enumération Salinity représentant les différents niveaux de salinité de l'eau.
 * Les niveaux de salinité sont : SALTWATER ("eau salée"), BRACKISHWATER ("eau saumâtre"), FRESHWATER ("eau douce").
 */
public enum Salinity {
    SALTWATER("eau salée"), // Niveau de salinité : eau salée
    BRACKISHWATER("eau saumâtre"), // Niveau de salinité : eau saumâtre
    FRESHWATER("eau douce"); // Niveau de salinité : eau douce

    private final String value; // Valeur de la salinité

    /**
     * Constructeur de l'énumération Salinity.
     * @param salinity la valeur de la salinité.
     */
    Salinity(String salinity) {
        this.value = salinity;
    }

    /**
     * Getter pour la valeur de la salinité.
     * @return la valeur de la salinité.
     */
    public String getValue() {
        return value;
    }

    public Salinity increment() {
        Salinity[] salinities = Salinity.values();
        int currentIndex = this.ordinal();
        if (currentIndex < salinities.length - 1) {
            return salinities[currentIndex + 1];
        } else {
            return this;
        }
    }

    public Salinity decrement() {
        int currentIndex = this.ordinal();
        if (currentIndex > 0) {
            return Salinity.values()[currentIndex - 1];
        } else {
            return this;
        }
    }
}
