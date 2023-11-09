package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;

public class Unicorn extends Creature {
    private String name;
    private Gender sexe;
    private double weight;
    private double height;
    private boolean isSleeping;
    private boolean isSick;

    // Attributs speciaux type enumeration
    private Age age;
    private Hunger hunger;

    /**
     * Constructeur
     *
     * @param name   Nom de l'espece
     * @param sexe   Male ou femelle
     * @param weight Poids en kg
     * @param height Taille en m
     */
    public Unicorn(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height);

        this.isSleeping = false;
        this.isSick = false;

        this.age = Age.BABY;
        this.hunger = Hunger.SATISFIED;
    }
}
