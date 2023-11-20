package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.consumable.composition.Food;

import java.util.ArrayList;
import java.util.Arrays;

import static net.zoofantastique.controller.creature.behavior.Hunger.SATISFIED;

public abstract class Enclosure {
    // Attributs
    private final String enclosureType = getClass().getSimpleName();
    private String name;
    private double surface;
    private int max;
    private int nbCreature;
    private ArrayList<Creature> listCreature = new ArrayList<>();

    // Attribus spéciaux type enum
    private Cleanness cleanness;

    public Enclosure(String name, double surface, int max) {
        this.name = name;
        this.surface = surface;
        this.max = max;
        this.listCreature = new ArrayList<>(0);
        this.nbCreature = 0;
        this.cleanness = Cleanness.CORRECT;
    }

    public Enclosure(String name, double surface, int max, ArrayList<Creature> listCreature) {
        this.name = name;
        this.surface = surface;
        this.max = max;
        this.listCreature = listCreature;

        this.nbCreature = 0;
        this.cleanness = Cleanness.CORRECT;
    }

    // Méthodes
    public void addCreature(Creature... creatures) {
        int totalCreatures = nbCreature + creatures.length;

        if (totalCreatures <= max) {
            this.listCreature.addAll(Arrays.asList(creatures));
            nbCreature += creatures.length;
        } else {
            System.err.println("Pas assez de places disponibles!");
        }
    }

    public void removeCreature(Creature... creaturesToRemove) {
        for (Creature creature : creaturesToRemove) {
            if (listCreature.contains(creature)) {
                listCreature.remove(creature);
                nbCreature--;
            } else {
                System.err.println("La créature:\n" + creature + "\nn'est pas dans l'enclos!");
            }
        }
    }

    public void feedCreature(Food food, Creature creature){
        if (listCreature.contains(creature)) {
            // TODO : Vérifier si la nourriture est compatible avec la créature
            if (creature.getHunger() != SATISFIED) {
                creature.eat(food);
            }
        } else {
            System.err.println("La créature:\n" + creature + "\nn'est pas dans l'enclos!");
        }
    }

    public void maintenance() {
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        // TODO : thread d'un temps aléatoire dans une intervalle donné
        getCleanness().clean();
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue());
    }

    // Getter et Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getSurface() {
        return surface;
    }
    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }

    public int getNbCreature() {
        return nbCreature;
    }
    public void setNbCreature(int nbCreature) {
        this.nbCreature = nbCreature;
    }

    public ArrayList<Creature> getListCreature() {
        return listCreature;
    }
    public void setListCreature(ArrayList<Creature> listCreature) {
        this.listCreature = listCreature;
    }

    public Cleanness getCleanness() {
        return cleanness;
    }
    public void setCleanness(Cleanness cleanness) {
        this.cleanness = cleanness;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<-/ " + enclosureType + " \\->\n");
        sb.append("--------------")
                .append("\nNom: ").append(name)
                .append("\nSuperficie: ").append(getSurface())
                .append("\nMax creatures: ").append(getMax())
                .append("\nNb creatures: ").append(getNbCreature())
                .append("\nPropreté: ").append(getCleanness().getValue());
        // Ajoute le toString de chaque creature
        for (Creature creature : listCreature) {
            sb.append("\n").append(creature.toString());
        }
        return sb.toString();
    }
}
