package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;

public class Megalodon extends Creature {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }
}