package net.zoofantastique.controller.enclosure.behavior;

/**
 * Enumération Salinity représentant le niveau de salinité de l'eau.
 */
public enum Salinity {
    SALTWATER("eau salée"),
    BRACKISHWATER("eau saumâtre"),
    FRESHWATER("eau douce");

    // Attributs
    private final String value; // Valeur de la salinité

    // Constructeur
    Salinity(String salinity) {
        this.value = salinity;
    }

    // Méthodes

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

    // Getter et setter

    public String getValue() {
        return value;
    }
}
