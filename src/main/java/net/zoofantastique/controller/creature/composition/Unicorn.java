package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Runner;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

public class Unicorn extends Viviparous implements Runner {
    public Unicorn(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "hihihiha");
    }

    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }
}