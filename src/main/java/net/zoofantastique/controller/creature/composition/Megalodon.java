package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

public class Megalodon extends Oviparous implements Swimmer {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }


    @Ovveride
    public Oviparous eggsHatch(){
        Random random = new Random();
        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble(); // a modifier
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble(); // a modifier

        if (random.nextInt(2)) {
            Gender babySexe = Gender.FEMALE;
        }
        else {
            Gender babySexe = Gender.MALE;
        }
        return new Megalodon(getName(), babySexe, babyWeight, babyHeight, getShout());
    }
}