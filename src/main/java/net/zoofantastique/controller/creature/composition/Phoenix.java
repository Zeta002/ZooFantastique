package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;

public class Phoenix extends Creature {
    public Phoenix(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "Coua coua");
    }
}