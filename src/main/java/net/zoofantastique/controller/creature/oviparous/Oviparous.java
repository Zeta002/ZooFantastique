package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;

import java.util.Random;

public class Oviparous extends Creature{
    private int incubationDuration;

    public Oviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    public Oviparous layEggs() {
        // ajouter temps d'attente
        return eggsHatch();
    }

    private Oviparous eggsHatch() {
        Random random = new Random();
        double babyWeight = 0.0;
        double babyHeight = 0.0;
        Gender babySexe;
        switch (getName()) {
            case "Dragon":
                babyWeight = 7.0 + (12.0 - 7.0) * random.nextDouble();
                babyHeight = 0.9 + (1.20 - 0.9) * random.nextDouble();
                break;
            case "Kraken":
                babyWeight = 7.20 + (8.700 - 7.20) * random.nextDouble();
                babyHeight = 85.0 + (105.0 - 85.0) * random.nextDouble();
                break;
            case "Phoenix":
                babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
                babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();
                break;
        }

        if (0 + (2 - 1) * random.nextInt() == 1) {
            babySexe = Gender.FEMALE;
        }
        else {
            babySexe = Gender.MALE;
        }

        Oviparous baby = new Oviparous(getName(), babySexe, babyWeight, babyHeight, getShout());
        return baby;
    }

    public String toString() {
        return "0viparous[nameSpecies = "+getName()+
                ", sexe = "+getSexe()+
                ", weight = "+getWeight()+", height = "+getHeight()+
                ", shout = "+getShout()+"]";
    }

}


