package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

public class Megalodon extends Oviparous implements Swimmer {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }


    @Override
    public Oviparous eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble(); // a modifier
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble(); // a modifier

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Megalodon(getName(), babySexe, babyWeight, babyHeight);
    }
}