package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;

public class Mermaid extends Creature implements Swimmer {
    public Mermaid(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "*chant mélodieux*");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }
}