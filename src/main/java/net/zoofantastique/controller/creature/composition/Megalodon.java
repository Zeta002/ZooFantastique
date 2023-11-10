package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

public class Megalodon extends Oviparous implements Swimmer {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }
}