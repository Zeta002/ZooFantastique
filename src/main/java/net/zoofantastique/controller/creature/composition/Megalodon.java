package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;

public class Megalodon extends Creature implements Swimmer {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }
}