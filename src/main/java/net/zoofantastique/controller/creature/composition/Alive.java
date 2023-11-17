package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;

public abstract class Alive {
    // Attributs
    // Nom de l'espece
    private final String species = getClass().getSimpleName();
    // Nom pour l'être vivant
    String name;
    // Male ou femelle uniquement
    Gender sexe;
    // Age de l'être vivant
    Age age;

    /**
     * Constructeur
     *
     * @author Angelo P.
     * @param name Nom de l'espèce
     * @param sexe Male ou femelle
     * @param age Age initial
     */
    public Alive(String name, Gender sexe, Age age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<-/ " + species + " \\->\n");
        sb.append("--------------")
                .append("\nNom: ").append(name)
                .append("\nSexe: ").append(sexe.getSexeStatus())
                .append("\nAge: ").append(age.getValue());
        return sb.toString();
    }
}
