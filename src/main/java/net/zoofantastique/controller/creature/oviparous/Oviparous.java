package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;

import java.util.Random;

public abstract class Oviparous extends Creature{
    // durée d'incubation
    private int incubationDuration;

    // Constructeur
    protected Oviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    /**
     * retourne une instance d'un ovipare au bout d'un
     * certain temps d'incubation
     */
    public Oviparous layEggs(Creature partenaire) {
        Creature female = fertilizable(partenaire);
        if (female == null) {
            System.out.println("La fécondation semble impossible");
            return null;
        }
        System.out.println("Un nouvel arrivant semble être prévu pour bientôt");
        female.setPregnant(true);
        // ajouter temps d'attente
        return ((Oviparous) female).eggsHatch();
    }

    /**
     * retourne une instance de bébé creature de la même
     * espèce que ces parents
     *
     * @return un bébé ovipare
     */

    public abstract Oviparous eggsHatch();


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDurée d'incubation: ").append(incubationDuration).append("s")
                .append("\n");
        return sb.toString();
    }
}


