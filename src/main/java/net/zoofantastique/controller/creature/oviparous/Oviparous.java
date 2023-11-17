package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;

import java.util.Random;

public class Oviparous extends Creature{
    // durée d'incubation
    private int incubationDuration;

    // Constructeur
    protected Oviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    /**
     * retourne une instance d'un ovipare au bout d'un
     * certain temps d'incubation
     *
     * @author Aurore M.
     * @return une instance d'un ovipare
     */
    public Oviparous layEggs() {
        // ajouter temps d'attente
        return eggsHatch();
    }

    /**
     * retourne une instance de bébé creature de la même
     * espèce que ces parents
     *
     * @author Aurore M.
     * @return un bébé ovipare
     */
    private Oviparous eggsHatch() {
        Random random = new Random();
        double babyWeight = 0.0;
        double babyHeight = 0.0;
        Gender babySexe;
        // TODO modifier le switch pour qu'il prenne en compte l'espece des parents
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

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }
        else {
            babySexe = Gender.MALE;
        }

        return new Oviparous(getName(), babySexe, babyWeight, babyHeight, getShout());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDurée d'incubation: ").append(incubationDuration).append("s")
                .append("\n");
        return sb.toString();
    }
}


