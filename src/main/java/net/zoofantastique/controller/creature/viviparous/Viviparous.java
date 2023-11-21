package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

/**
 * Classe abstraite Viviparous qui représente une créature vivipare dans un zoo.
 * Une créature vivipare est une créature qui donne naissance à des jeunes vivants, qui a une durée de gestation et qui peut initier une grossesse.
 * Cette classe étend la classe Creature.
 */
public abstract class Viviparous extends Creature {
    // Attributs
    private int gestationDuration;

    protected Viviparous(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, weight, height, shout);
    }

    // Méthodes

    /**
     * Méthode pour initier une grossesse chez une créature vivipare.
     * Cette méthode vérifie d'abord si la fécondation est possible avec le partenaire fourni.
     * Si la fécondation est possible, la créature femelle est mise en état de grossesse et la méthode giveBirth est appelée pour faire naître le bébé.
     * Si la fécondation n'est pas possible, un message est affiché et la méthode renvoie null.
     *
     * @param partenaire La créature avec laquelle vérifier la possibilité de fécondation.
     * @return Un nouveau bébé vivipare si la fécondation est possible, null sinon.
     */
    public Viviparous initiatePregnancy(Creature partenaire) {
        Creature female = fertilizable(partenaire);
        if (female == null) {
            System.out.println("L'accouplement semble impossible");
            return null;
        }
        System.out.println("Un nouvel arrivant semble être prévu pour bientôt");
        female.setPregnant(true);
        // TODO temps d'incubation thread
        return ((Viviparous) female).giveBirth();
    }

    /**
     * Retourne une instance de bébé creature vivipare.
     *
     * @return Un nouveau bébé vivipare.
     */
    public abstract Viviparous giveBirth();

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature vivipare.
     * Construit une chaîne de caractères contenant les informations de la créature (obtenues en appelant la méthode toString de la classe parente) et la durée de gestation.
     *
     * @return Une chaîne de caractères représentant la créature vivipare.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDurée d'incubation: ").append(gestationDuration).append("s")
                .append("\n");
        return sb.toString();
    }
}
