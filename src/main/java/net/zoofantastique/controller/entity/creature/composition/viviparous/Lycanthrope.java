package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Rank;
import net.zoofantastique.controller.entity.creature.behavior.Runner;
import net.zoofantastique.controller.entity.creature.behavior.Pack;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.utils.Utils;

import java.util.Random;

import static net.zoofantastique.view.ConsoleTricks.boldText;

/**
 * Classe Lycanthrope qui représente un lycanthrope dans un zoo.
 * Un lycanthrope est une créature vivipare qui peut courir et possède un rang.
 * Cette classe étend la classe Creature et implémente l'interface Viviparous, Runner et Rank.
 */
public class Lycanthrope extends Creature implements Viviparous, Runner, Rank {
    // Attributs
    private double strength; // Force
    private double dominanceFactor; // Facteur de dominance
    private double impetuosityFactor; // Facteur d'impétuosité
    private int rank; // Rang
    private Pack pack; // Meute
    private double level; // Niveau



    public Lycanthrope(String name, Gender sexe) {
        super(name, sexe, "ahouuuuuu");

        this.strength = Math.round((Utils.getRandomDoubleInRange(1.0, 10.0)));
        this.impetuosityFactor = Math.round((Utils.getRandomDoubleInRange(0.5, 1.5)));
        this.dominanceFactor = 0;
        this.rank = 0;
        this.pack = null;

        updateAndRestart(70, 34);

    }

    // Getter et setter

    public double getLevel() {
        return level;
    }
    public void setLevel(double level) {
        this.level = level;
    }
    public void calcLevel() {
        double rankFactor = (1 + (1 - (double) this.rank / (double) greekAlphabet.size()));
        double ageFactor = getAge().getAgePowerFactor();
        this.level = Math.round(((this.strength + this.dominanceFactor) * ageFactor * rankFactor) * 100) / 100.0 ;
    }

    public int getRank() {
        return rank;
    }
    public String getRankString() {
        if (rank < greekAlphabet.size()) {
            return greekAlphabet.get(rank);
        } else {
            return "Le rang semble incorrect";
        }
    }
    public void setRank(int rank) {
        if (rank > greekAlphabet.size()) {
            this.rank = greekAlphabet.size() - 1;
        } else {
            this.rank = rank;
        }
    }

    public double getStrength() {
        return strength;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDominanceFactor() {
        return dominanceFactor;
    }
    public void setDominanceFactor(double dominanceFactor) {
        this.dominanceFactor = dominanceFactor;
    }

    public double getImpetuosityFactor() {
        return impetuosityFactor;
    }
    public void setImpetuosityFactor(double impetuosityFactor) {
        this.impetuosityFactor = impetuosityFactor;
    }

    public Pack getPack() {
        return pack;
    }
    public void setPack(Pack pack) {
        this.pack = pack;
    }

    /**
     * Méthode pour faire courir un Lycanthrope.
     * Affiche un message indiquant que le Lycanthrope court, en précisant le nom du Lycanthrope.
     */
    @Override
    public void running() {
        System.out.println(super.getName() + " *cours*");
    }

    // TODO : doc
    public String showStats() {
        return "<-/ " + boldText(getName()) + " \\->\n" +
                "\nForce : " + this.strength +
                "\nFacteur d'impétuosité: " + this.impetuosityFactor +
                "\nFacteur de dominance: " + this.dominanceFactor +
                "\nRang: " + this.rank +
                "\nNiveau: " + this.level;
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
    public Lycanthrope giveBirth() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Lycanthrope(getName(), babySexe);
    }
}