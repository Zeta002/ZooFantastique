package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Runner;

public class Unicorn extends Creature implements Runner {
    public Unicorn(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "hihihiha");
    }

    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }
}