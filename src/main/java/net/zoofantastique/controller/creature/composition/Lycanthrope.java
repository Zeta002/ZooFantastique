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

    @Ovveride
    public Viviparous giveBirth(){
        Random random = new Random();
        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();

        if (random.nextInt(2)) {
            Gender babySexe = Gender.FEMALE;
        }
        else {
            Gender babySexe = Gender.MALE;
        }
        return new Lycanthrope(getName(), babySexe, babyWeight, babyHeight, getShout());
    }
}