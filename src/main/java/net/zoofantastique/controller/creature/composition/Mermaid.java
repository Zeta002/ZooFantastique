package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

import java.util.Random;

public class Mermaid extends Viviparous implements Swimmer {
    public Mermaid(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "*chant mélodieux*");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    @Override
    public Viviparous giveBirth(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;
        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Mermaid(getName(), babySexe, babyWeight, babyHeight);
    }
}