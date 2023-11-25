package net.zoofantastique;

import net.zoofantastique.controller.enclosure.behavior.Cleanness;
import net.zoofantastique.controller.entity.creature.behavior.Age;

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

        System.out.println(Age.BABY.getValue());
        System.out.println(Age.CHILD.getValue());
        System.out.println(Age.ADULT.getValue());
        System.out.println(Age.OLD.getValue());
        System.out.println(Age.DEAD.getValue());

        System.out.println("------------");

        System.out.println(Age.BABY.nextAge().getValue());
        System.out.println(Age.CHILD.nextAge().getValue());
        System.out.println(Age.ADULT.nextAge().getValue());
        System.out.println(Age.OLD.nextAge().getValue());
        System.out.println(Age.DEAD.nextAge().getValue());

        System.out.println("------------");

        System.out.println(Age.DEAD.nextAge().nextAge().nextAge().nextAge().nextAge().getValue());

        System.out.println("------------");

        System.out.println(Cleanness.BAD.getValue());
        System.out.println(Cleanness.CORRECT.getValue());
        System.out.println(Cleanness.GOOD.getValue());

        System.out.println("------------");

        System.out.println(Cleanness.BAD.clean().getValue());
        System.out.println(Cleanness.CORRECT.clean().getValue());
        System.out.println(Cleanness.GOOD.clean().getValue());

        System.out.println("------------");

        System.out.println(Cleanness.BAD.deteriorate().getValue());
        System.out.println(Cleanness.CORRECT.deteriorate().getValue());
        System.out.println(Cleanness.GOOD.deteriorate().getValue());

        System.out.println("------------");

        System.out.println(Cleanness.BAD.deteriorate().deteriorate().deteriorate().deteriorate().deteriorate().getValue());
    }
}
