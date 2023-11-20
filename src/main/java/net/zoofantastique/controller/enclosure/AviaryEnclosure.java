package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class AviaryEnclosure extends Enclosure {

    private double roofHeight; // hauteur du toit

    public AviaryEnclosure(String name, double surface, double roofHeight, int max) {
        super(name, surface, max);
        this.roofHeight = roofHeight;
    }

    public AviaryEnclosure(String name, double surface, double roofHeight, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
        this.roofHeight = roofHeight;
    }
}
