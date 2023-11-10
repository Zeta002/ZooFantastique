package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;
import net.zoofantastique.controller.creature.consumable.composition.Food;

public abstract class Creature implements Alive {
    // Attributs
    private String name;
    private final String shout;
    private final Gender sexe;
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
     * @param name Nom de l'espece
     * @param sexe Male ou femelle
     * @param weight Poids en kg
     * @param height Taille en m
     */
    public Creature(String name, Gender sexe, double weight, double height, String shout) {
        this.name = name;
        this.sexe = sexe;
        this.weight = weight;
        this.height = height;
        this.shout = shout;

        this.isSleeping = false;
        this.isSick = false;

        this.age = Age.BABY;
        this.hunger = Hunger.SATISFIED;
    }

    // Methodes
    /**
     * Donne de la nourriture a la creature
     *
     * @param food  nourriture donner a la creature
     */
    public void eat(Food food) {
        if (isSleeping) {
            System.err.println("Tu ne peux pas faire ça car la créature sélectionner dors actuellement.");
        }
        hunger.setHunger(food.getValue());
    }

    /**
     * La creature crie, emet un son, si besoin on peut changer
     * le nom en scream, shout voulant dire la meme chose
     */
    public void shout()
    {
        System.out.println(name + " fait " + shout);
    }

    /**
     * La creature est soigne, suposement par un acteur externe,
     * agie sur l'attribut health
     */
    public void healed() {
        isSick = false;
    }

    /**
     * Switch l'etat de sommeil de la creature
     */
    public void toggleSleeping() {
        isSleeping = !isSleeping;
    }

    /**
     * Passe a l'age suivant,
     */
    public void aging() {
        this.age = age.nextAge();
    }

    // Getter et Setter
    public Age getAge() {
        return age;
    }

    public String getAgeState() {
        return age.getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexe() {
        return sexe.getSexe();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHungerState() {
        return hunger.getState();
    }

    public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger.setHunger(hunger);
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }
}
