package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;

import java.util.Random;

public class Viviparous extends Creature{
    private int gestationDuration;

    protected Viviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    /**
     * retourne une instance d'un vivipare au bout d'un
     * certain temps de gestation
     *
     * @author Aurore M.
     * @return une instance d'un vivipare
     */
    public Viviparous initiatePregnancy() {
        // ajouter temps de grosses
        return giveBirth();
    }

    /**
     * retourne une instance de bébé creature de la même
     * espèce que ces parents
     *
     * @author Aurore M.
     * @return un bébé vivipare
     */
    private Viviparous giveBirth() {
        Random random = new Random();
        double babyWeight = 0.0;
        double babyHeight = 0.0;
        Gender babySexe;
        // TODO modifier le switch pour qu'il prenne en compte l'espece des parents
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

        if (random.nextInt() == 1) {
            babySexe = Gender.FEMALE;
        }
        else {
            babySexe = Gender.MALE;
        }

        return new Viviparous(getName(), babySexe, babyWeight, babyHeight, getShout());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Durée d'incubation: " + gestationDuration + "s";
    }
}
