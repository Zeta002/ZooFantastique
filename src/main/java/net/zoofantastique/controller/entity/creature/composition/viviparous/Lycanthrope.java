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
 * Cette classe étend la classe Viviparous et implémente l'interface Runner et Rank.
 */
public class Lycanthrope extends Creature implements Viviparous, Runner, Rank {

    private double strength;
    private double dominanceFactor;
    private double impetuosityFactor;
    private int rank;
    private Pack pack;
    private double level;

    public Lycanthrope(String name, Gender sexe) {
        super(name, sexe, "ahouuuuuu");

        this.strength = Math.round((Utils.getRandomDoubleInRange(1.0, 10.0)));
        this.impetuosityFactor = Math.round((Utils.getRandomDoubleInRange(0.5, 1.5)));
        this.dominanceFactor = 0;
        this.rank = 1;
        this.pack = null;

        setAgeScale(70);
        setDimHunger(34);
    }


    public void setLevel() {
        double rankFactor = (1 + (1 - (double) this.rank / (double) greekAlphabet.size()));
        double ageFactor = getAge().getAgePowerFactor();
        this.level = Math.round(((this.strength + this.dominanceFactor) * ageFactor * rankFactor) * 100) / 100.0 ;
    }

    public double getLevel() {
        return level;
    }

    public int getRank() {
        return rank;
    }
    public String getRankString() {

        if (rank < greekAlphabet.size()) {
            return getName() + " est au rang de " + greekAlphabet.get(rank);
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

    public void setLevel(double level) {
        this.level = level;
    }

    /**
     * Méthode pour faire courir un Lycanthrope.
     * Affiche un message indiquant que le Lycanthrope court, en précisant le nom du Lycanthrope.
     */
    @Override
    public void running() {
        System.out.println(super.getName() + " *cours*");
    }

    public void showStats() {
        StringBuilder sb = new StringBuilder("<-/ " + boldText(getName()) + " \\->\n");
        sb.append("\nForce : ").append(this.strength)
                .append("\nFacteur d'impétuosité: ").append(this.impetuosityFactor)
                .append("\nFacteur de dominance: ").append(this.dominanceFactor)
                .append("\nRang: ").append(this.rank)
                .append("\nNiveau: ").append(this.level);
        System.out.println(sb);
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

        double babyWeight = Utils.getRandomDoubleInRange(1, 4);
        double babyHeight = Utils.getRandomDoubleInRange(0.2, 0.5);

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Lycanthrope(getName(), babySexe);
    }
}