package net.zoofantastique.controller.creature.behavior;

public enum Gender {
    MALE("Male"),
    FEMALE("Femelle");

    private final String sexe;

    Gender(String sexe) {
        this.sexe = sexe;
    }

    public Gender getSexe() {
        return this;
    }

    public String getSexeStatus() {
        return this.sexe;
    }
}
