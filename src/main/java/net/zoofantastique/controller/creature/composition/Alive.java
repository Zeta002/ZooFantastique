package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;

public interface Alive {
    // Nom de l'espece ou nom propre
    String name = null;
    // Male ou femelle uniquement
    Gender sexe = null;
    int age = 0;
}
