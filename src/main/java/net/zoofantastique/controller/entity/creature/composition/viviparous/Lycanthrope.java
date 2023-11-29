package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Runner;

import java.util.Random;

/**
 * Classe Lycanthrope qui représente un lycanthrope dans un zoo.
 * Un lycanthrope est une créature vivipare qui peut courir.
 * Cette classe étend la classe Viviparous et implémente l'interface Runner.
 */
public class Lycanthrope extends Viviparous implements Runner {
    public Lycanthrope(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "ahouuuuuu");
    }

    /**
     * Méthode pour faire courir un Lycanthrope.
     * Affiche un message indiquant que le Lycanthrope court, en précisant le nom du Lycanthrope.
     */
    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }

    /**
     * Méthode pour faire naître un bébé Lycanthrope.
     * Cette méthode génère un nouveau Lycanthrope avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Un nouveau Lycanthrope qui vient de naître.
     */
    @Override
    public Lycanthrope giveBirth(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = getRandomInRange(1, 4);
        double babyHeight = getRandomInRange(0.2, 0.5);

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Lycanthrope(getName(), babySexe, babyWeight, babyHeight);
    }
}