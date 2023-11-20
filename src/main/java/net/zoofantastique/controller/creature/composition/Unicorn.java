package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Runner;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

import java.util.Random;

public class Unicorn extends Viviparous implements Runner {
    public Unicorn(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "hihihiha");
    }

    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }

    @Override
    public Viviparous giveBirth(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 0.5 + (0.75 - 0.5) * random.nextDouble();
        double babyHeight = 0.9 + (1.15 - 0.9) * random.nextDouble();

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Unicorn(getName(), babySexe, babyWeight, babyHeight);
    }
}