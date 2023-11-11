package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;

public class Alive {
    // Nom de l'espece ou nom propre
    String name;
    // Male ou femelle uniquement
    Gender sexe;
    // Age de l'être vivant
    Age age;

    protected Alive(String name, Gender sexe, Age age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
    }
}
