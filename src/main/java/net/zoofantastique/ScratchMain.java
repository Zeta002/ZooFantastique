package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Dragon;
import net.zoofantastique.controller.creature.consumable.food.Beefsteak;
import net.zoofantastique.controller.creature.oviparous.Oviparous;
import net.zoofantastique.controller.enclosure.Enclosure;
import net.zoofantastique.controller.enclosure.StandardEnclosure;

public class ScratchMain {
    public static void main(String[] args) {
        Oviparous v = new Dragon("Bidule", Gender.MALE, 2000.0, 100.0);
        Oviparous va = new Dragon("Cauchemar 2", Gender.FEMALE, 4000.0, 200.0);
        Oviparous vi = new Dragon("Un truc", Gender.MALE, 6000.0, 400.0);
        Oviparous ve = new Dragon("Un con", Gender.FEMALE, 8000.0, 800.0);
        Oviparous vu = new Dragon("Un voyeur", Gender.FEMALE, 8000.0, 800.0);

        Enclosure e = new StandardEnclosure("e1", 100.0, 4);

//        e.addCreature(v);
//        e.addCreature(va);
//        e.addCreature(vi);
//        e.addCreature(ve);

        e.addCreature(v, va, vi, ve);

        e.removeCreature(vu);

        System.out.println(e);
    }
}
