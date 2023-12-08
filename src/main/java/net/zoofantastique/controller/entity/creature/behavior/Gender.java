package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Enumération Age représentant l'âge d'une créature.
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Femelle");

    // Attributs
    private final String sexe;

    // Constructeur
    Gender(String sexe) {
        this.sexe = sexe;
    }

    // Getter et setter

    public Gender getSexe() {
        return this;
    }
    public String getSexeStatus() {
        return this.sexe;
    }
}
