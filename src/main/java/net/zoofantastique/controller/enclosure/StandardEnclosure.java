package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class StandardEnclosure extends Enclosure {

    public StandardEnclosure(String name, double surface, int max) {
        super(name, surface, max);
    }

    public StandardEnclosure(String name, double surface, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
    }
}
