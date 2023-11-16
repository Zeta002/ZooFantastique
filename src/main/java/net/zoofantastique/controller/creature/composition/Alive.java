package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;

public abstract class Alive {
    // Attributs
    // Nom de l'espece ou nom propre
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
        return "<-/ " + getClass().getSimpleName() + " \\->" +
                "\n--------------\n" +
                "Nom: " + name + "\n" +
                "Sexe: " + sexe.getSexeStatus() + "\n" +
                "Age: " + age.getValue();
    }
}
