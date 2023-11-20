package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

public class Kraken extends Oviparous implements Swimmer {
    public Kraken(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "bulou bulou bulou");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    @Override
    public Oviparous eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 7.20 + (8.700 - 7.20) * random.nextDouble();
        double babyHeight = 85.0 + (105.0 - 85.0) * random.nextDouble();
        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }
        return new Kraken(getName(), babySexe, babyWeight, babyHeight);
    }
}