package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

public class Nymph extends Viviparous {
    public Nymph(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "ahahah");
    }
}