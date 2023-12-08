package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe Kraken qui représente un kraken dans un zoo.
 * Un kraken est une créature ovipare qui peut nager.
 * Cette classe étend la classe Creature et implémente l'interface Oviparous, Swimmer.
 */
public class Kraken extends Creature implements Oviparous, Swimmer {

    public Kraken(String name, Gender sexe) {
        super(name, sexe, "bulou bulou bulou");
        setMinHeight(new ArrayList<>(List.of(0.5, 4.5, 8.5, 15.0, 17.0)));
        setMaxHeight(new ArrayList<>(List.of(1.0, 7.5, 13.0, 21.0, 22.0)));
        setMinWeight(new ArrayList<>(List.of(50.0, 800.0, 2500., 5000., 5500.)));
        setMaxWeight(new ArrayList<>(List.of(120.0, 2000.0, 4000., 8500., 9500.)));

        setAgeScale(60);
        setDimHunger(30);

        calcSizeAndWeight();
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
    public Kraken eggsHatch() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Kraken(getName(), babySexe);
    }
}