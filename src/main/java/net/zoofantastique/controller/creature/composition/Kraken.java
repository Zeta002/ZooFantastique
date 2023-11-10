package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

public class Kraken extends Oviparous implements Swimmer {
    public Kraken(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "bulou bulou bulou");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }
}