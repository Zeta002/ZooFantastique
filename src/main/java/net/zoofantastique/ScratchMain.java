package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Dragon;
import net.zoofantastique.controller.enclosure.Enclosure;

public class ScratchMain {
    public static void main(String[] args) {
//        Oviparous v = new Dragon("Cauchemar", Gender.MALE, 1000.0, 2.0);
//        System.out.println(v);
//
//        System.out.println(new Beefsteak());
//
//        for
//            name = random
//            e.add(new Truc(name))
//            e.rem(i)

        Enclosure e = new Enclosure("Le nom", 100.0, 10);

        for (int i = 0; i < 4; i++) {
            e.addCreature(new Dragon("Test", Gender.MALE, 200.0, 200.0));
        }

        System.out.println(e);

        e.removeCreature(e.getListCreature().get(0));

        System.out.println("--------");
        System.out.println(e);
    }
}
