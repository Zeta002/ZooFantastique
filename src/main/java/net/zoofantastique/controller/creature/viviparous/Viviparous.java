package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

public abstract class Viviparous extends Creature{
    private int gestationDuration;

    protected Viviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    /**
     * retourne une instance d'un vivipare au bout d'un
     * certain temps de gestation
     */
    public Viviparous initiatePregnancy(Creature partenaire) {
        Creature female = fertilizable(partenaire);
        if (female == null) {
            System.out.println("L'accouplement semble impossible");
            return null;
        }
        System.out.println("Un nouvel arrivant semble être prévu pour bientôt");
        female.setPregnant(true);
        // ajouter temps de grosses
        return ((Viviparous) female).giveBirth();
    }

    /**
     * retourne une instance de bébé creature de la même
     * espèce que ces parents
     *
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
