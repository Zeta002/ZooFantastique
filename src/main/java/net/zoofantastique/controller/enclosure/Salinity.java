package net.zoofantastique.controller.enclosure;

/**
 * Enumération Salinity représentant les différents niveaux de salinité de l'eau.
 * Les niveaux de salinité sont : SALTWATER ("eau salée"), BRACKISHWATER ("eau saumâtre"), FRESHWATER ("eau douce").
 */
public enum Salinity {
    SALTWATER("eau salée"), // Niveau de salinité : eau salée
    BRACKISHWATER("eau saumâtre"), // Niveau de salinité : eau saumâtre
    FRESHWATER("eau douce"); // Niveau de salinité : eau douce

    private String value; // Valeur de la salinité

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

    /**
     * Setter pour la valeur de la salinité.
     * @param value la nouvelle valeur de la salinité.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Cette méthode est utilisée pour diminuer le niveau de salinité de l'eau.
     * Elle vérifie le niveau de salinité actuel et le diminue au niveau précédent.
     * Si la salinité actuelle est FRESHWATER, elle reste la même car c'est le niveau le plus bas.
     * Si la salinité actuelle est BRACKISHWATER, elle passe à FRESHWATER.
     * Si la salinité actuelle est SALTWATER, elle passe à BRACKISHWATER.
     */
    public void decreaseSalinity() {
        switch (this) {
            case SALTWATER:
                // Diminue la salinité de SALTWATER à BRACKISHWATER.
                this.setValue(BRACKISHWATER.getValue());
                break;
            case BRACKISHWATER:
                // Diminue la salinité de BRACKISHWATER à FRESHWATER.
                this.setValue(FRESHWATER.getValue());
                break;
            case FRESHWATER:
                // La salinité reste la même car FRESHWATER est le niveau le plus bas.
                break;
        }
    }

    /**
     * Cette méthode est utilisée pour augmenter le niveau de salinité de l'eau.
     * Elle vérifie le niveau de salinité actuel et l'augmente au niveau suivant.
     * Si la salinité actuelle est SALTWATER, elle reste la même car c'est le niveau le plus élevé.
     * Si la salinité actuelle est BRACKISHWATER, elle passe à SALTWATER.
     * Si la salinité actuelle est FRESHWATER, elle passe à BRACKISHWATER.
     */
    public void inscreaseSalinity() {
        switch (this) {
            case SALTWATER:
                // La salinité reste la même car SALTWATER est le niveau le plus élevé.
                break;
            case BRACKISHWATER:
                // Augmente la salinité de BRACKISHWATER à SALTWATER.
                this.setValue(SALTWATER.getValue());
                break;
            case FRESHWATER:
                // Augmente la salinité de FRESHWATER à BRACKISHWATER.
                this.setValue(BRACKISHWATER.getValue());
                break;
        }
    }
}
