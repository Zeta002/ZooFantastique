package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class AquariumEnclosure extends Enclosure {

    public AquariumEnclosure(String name, double surface, int max) {
        super(name, surface, max);
    }

    public AquariumEnclosure(String name, double surface, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
    }
}
