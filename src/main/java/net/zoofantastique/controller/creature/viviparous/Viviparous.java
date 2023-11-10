package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;

import java.util.Random;

public class Viviparous extends Creature{
    private int gestationDuration;

    public Viviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    public Viviparous getPregnant() {
        // ajouter temps de grosses
        return giveBirth();
    }

    private Viviparous giveBirth() {
        Random random = new Random();
        double babyWeight = 0.0;
        double babyHeight = 0.0;
        Gender babySexe;
        switch (getName()) {
            case "Lycanthrope":
            case "Mermaid":
            case "Nymph":
                babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
                babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();
                break;
            case "Unicorn":
                babyWeight = 0.5 + (0.75 - 0.5) * random.nextDouble();
                babyHeight = 0.9 + (1.15 - 0.9) * random.nextDouble();
                break;
        }

        if (0 + (2 - 1) * random.nextInt() == 1) {
            babySexe = Gender.FEMALE;
        }
        else {
            babySexe = Gender.MALE;
        }

        Viviparous baby = new Viviparous(getName(), babySexe, babyWeight, babyHeight, getShout());
        return baby;
    }

    public String toString() {
        return "Viviparous[nameSpecies = "+getName()+
                ", sexe = "+getSexe()+
                ", weight = "+getWeight()+", height = "+getHeight()+
                ", shout = "+getShout()+"]";
    }
}
