package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.Random;

/**
 * Classe abstraite Oviparous qui représente une créature ovipare dans un zoo.
 * Une créature ovipare est une créature qui pond des œufs, qui a une durée d'incubation et qui peut faire éclore ses œufs.
 * Cette classe étend la classe Creature.
 */
public abstract class Oviparous extends Creature {
    // Attributs
    private int incubationDuration;

    // Constructeur
    protected Oviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    // Méthodes

    /**
     * Méthode pour faire pondre des œufs à une créature ovipare.
     * Cette méthode vérifie d'abord si la fécondation est possible avec le partenaire fourni.
     * Si la fécondation est possible, la créature femelle est mise en état de grossesse et la méthode eggsHatch est appelée pour faire éclore les œufs.
     * Si la fécondation n'est pas possible, un message est affiché et la méthode renvoie null.
     *
     * @param partenaire La créature avec laquelle vérifier la possibilité de fécondation.
     * @return Un nouveau bébé ovipare si la fécondation est possible, null sinon.
     */
    public Oviparous layEggs(Creature partenaire) {
        Creature female = fertilizable(partenaire);
        if (female == null) {
            System.err.println("La fécondation semble impossible.");
            return null;
        }
        System.out.println("Un nouvel arrivant semble être prévu pour bientôt!");
        female.setPregnant(true);
        // TODO temps d'incubation thread
        return ((Oviparous) female).eggsHatch();
    }

    /**
     * Retourne une instance de bébé creature ovipare.
     *
     * @return Un nouveau bébé ovipare.
     */
    public abstract Oviparous eggsHatch();

    public double getRandomInRange(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature ovipare.
     * Construit une chaîne de caractères contenant les informations de la créature (obtenues en appelant la méthode toString de la classe parente) et la durée d'incubation.
     *
     * @return Une chaîne de caractères représentant la créature ovipare.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDurée d'incubation: ").append(incubationDuration).append("s")
                .append("\n");
        return sb.toString();
    }
}


