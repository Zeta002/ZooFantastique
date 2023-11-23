package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;

import java.util.Random;

/**
 * Classe Kraken qui représente un kraken dans un zoo.
 * Un kraken est une créature ovipare qui peut nager.
 * Cette classe étend la classe Oviparous et implémente l'interface Swimmer.
 */
public class Kraken extends Oviparous implements Swimmer {
    public Kraken(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "bulou bulou bulou");
    }

    /**
     * Méthode pour faire nager un Kraken.
     * Affiche un message indiquant que le Kraken nage, en précisant le nom du Kraken.
     */
    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    /**
     * Méthode pour faire éclore les œufs d'un Kraken.
     * Cette méthode génère un nouveau Kraken avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Un nouveau Kraken qui vient d'éclore.
     */
    @Override
    public Oviparous eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 7.20 + (8.700 - 7.20) * random.nextDouble();
        double babyHeight = 85.0 + (105.0 - 85.0) * random.nextDouble();
        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }
        return new Kraken(getName(), babySexe, babyWeight, babyHeight);
    }
}