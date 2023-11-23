package net.zoofantastique.controller.creature.composition.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Swimmer;

import java.util.Random;

/**
 * Classe Megalodon qui représente un megalodon dans un zoo.
 * Un megalodon est une créature ovipare qui peut nager.
 * Cette classe étend la classe Oviparous et implémente l'interface Swimmer.
 */
public class Megalodon extends Oviparous implements Swimmer {
    public Megalodon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "crounch crounch");
    }

    /**
     * Méthode pour faire nager un Megalodon.
     * Affiche un message indiquant que le Megalodon nage, en précisant le nom du Megalodon.
     */
    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    /**
     * Méthode pour faire éclore les œufs d'un Megalodon.
     * Cette méthode génère un nouveau Megalodon avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Un nouveau Megalodon qui vient d'éclore.
     */
    @Override
    public Oviparous eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble(); // a modifier
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble(); // a modifier

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Megalodon(getName(), babySexe, babyWeight, babyHeight);
    }
}