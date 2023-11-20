package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class AviaryEnclosure extends Enclosure {

    public AviaryEnclosure(String name, double surface, int max) {
        super(name, surface, max);
    }

    public AviaryEnclosure(String name, double surface, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
    }
}
