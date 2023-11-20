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
    public abstract Viviparous giveBirth();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDurée d'incubation: ").append(gestationDuration).append("s")
                .append("\n");
        return sb.toString();
    }
}
