package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Flying;
import net.zoofantastique.controller.creature.behavior.Gender;

public class Phoenix extends Creature implements Flying {
    public Phoenix(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "coua coua");
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " *est entrain de voler*");
    }
}