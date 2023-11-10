package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Runner;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

public class Lycanthrope extends Viviparous implements Runner {
    public Lycanthrope(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "ahouuuuuu");
    }

    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }
}