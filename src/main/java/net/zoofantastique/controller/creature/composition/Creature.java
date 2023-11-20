package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;
import net.zoofantastique.controller.creature.consumable.composition.Food;

import static net.zoofantastique.controller.creature.behavior.Hunger.*;

public abstract class Creature extends Alive {
    // Attributs
    private final String shout;
    private double weight;
    private double height;
    private boolean isSleeping;
    private boolean isSick;
    private boolean isPregnant;

    // Attributs speciaux type enumeration
    private Hunger hunger;

    /**
     * Constructeur
     *
     * @author Angelo P.
     * @param weight Poids en kg
     * @param height Taille en m
     */
    public Creature(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, Age.BABY);

        this.weight = weight;
        this.height = height;
        this.shout = shout;

        this.isSleeping = false;
        this.isSick = false;

        this.hunger = SATISFIED;
    }

    // Methodes
    /**
     * La creature mange, agie sur l'enum hunger,
     * si elle dort alors elle ne peut pas manger,
     *
     * @author Angelo P.
     * @param food nourriture donner a la creature
     */
    public void eat(Food food) {
        if (isSleeping) {
            System.out.println("Tu ne peux pas faire ça car la créature sélectionner dors actuellement.");
            return;
        }

        int totalHungerValue = this.hunger.getHungerValue() + food.getValue();

        if (totalHungerValue >= 10) {
            this.hunger.setValue(10);
            setHunger(SATISFIED);
        } else if (totalHungerValue > 3) {
            this.hunger.setValue(totalHungerValue);
            setHunger(MEDIUM);
        } else {
            this.hunger.setValue(totalHungerValue);
            setHunger(HUNGRY);
        }
    }

    /**
     * La creature crie, emet un son, si besoin on peut changer
     * le nom en scream, shout voulant dire la meme chose
     *
     * @author Angelo P.
     */
    public void shout()
    {
        System.out.println(name + " fait " + shout);
    }

    /**
     * La creature est soigne, suposement par un acteur externe,
     * agie sur l'attribut isSick qui est la santé
     *
     * @author Angelo P.
     */
    public void healed() {
        isSick = false;
    }

    /**
     * Switch l'etat de sommeil de la creature
     *
     * @author Angelo P.
     */
    public void toggleSleeping() {
        isSleeping = !isSleeping;
    }

    /**
     * Passe a l'age suivant
     *
     * @author Angelo P.
     */
    public void aging() {
        this.age = this.age.nextAge();
    }

    public void checkSick() {
        if (isSick) {
            age = Age.DEAD;
        }
    }

    // Getter et Setter
    public Age getAge() {
        return age;
    }
    public String getAgeState() {
        return this.age.getValue();
    }
    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Gender getSexe() {
        return this.sexe.getSexe();
    }
    public String getSexeStatus() {
        return this.sexe.getSexeStatus();
    }

    public double getWeight() {
        return this.weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public String getShout() {
        return this.shout;
    }

    public String getHungerState() {
        return hunger.getState();
    }
    public Hunger getHunger() {
        return this.hunger;
    }
    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    public boolean isSleeping() {
        return this.isSleeping;
    }
    public void setSleeping(boolean sleeping) {
        this.isSleeping = sleeping;
    }

    public boolean isSick() {
        return this.isSick;
    }
    public void setSick(boolean sick) {
        checkSick();
        this.isSick = sick;
    }

    public boolean isPregnant() {
        return isPregnant;
    }
    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public Creature fertilizable(Creature partenaire) {
        if (partenaire.isPregnant() || this.isPregnant()) return null;

        if (this.getClass().equals(partenaire.getClass())) {
            if (this.getSexe() != partenaire.getSexe()) {
                if (this.getSexe() == Gender.FEMALE) {
                    return this;
                } else {
                    return partenaire;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCri: ").append(shout)
                .append("\nPoids: ").append(weight).append("kg")
                .append("\nTaille: ").append(height).append("m")
                .append("\nDort: ").append(isSleeping ? "Oui" : "Non")
                .append("\nMalade: ").append(isSick ? "Oui" : "Non")
                .append("\nFaim: ").append(hunger.getState());
        return sb.toString();
    }
}
