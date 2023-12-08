package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.utils.Utils;

import java.util.Random;

/**
 * Classe Megalodon qui représente un megalodon dans un zoo.
 * Un megalodon est une créature ovipare qui peut nager.
 * Cette classe étend la classe Creature et implémente l'interface Oviparous, Swimmer.
 */
public class Megalodon extends Creature implements Oviparous, Swimmer {
    // Constructeur
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
    public Megalodon eggsHatch() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = Utils.getRandomInRange(90, 130);
        double babyHeight = Utils.getRandomInRange(5, 7);

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Megalodon(getName(), babySexe, babyWeight, babyHeight);
    }
}