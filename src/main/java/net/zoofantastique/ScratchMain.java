package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.composition.Dragon;
import net.zoofantastique.controller.creature.composition.Unicorn;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

public class ScratchMain {
    public static void main(String[] args) {
//        Creature c1 = new Creature("Abdoul", "zhomme", 15.2, 52.3);
//        c1.setHunger(3);
//        System.out.println(c1.getHunger().getHunger());
//        System.out.println(c1.getHunger().getState());

//        Creature c2 = new Unicorn("Unicorn", Gender.MALE, 720.0, 2);
//        System.out.println(c2.getAgeState());

        Gender female = Gender.FEMALE;
        Gender male = Gender.MALE;
        Oviparous v1 = new Dragon("Dragon", Gender.MALE, 15.0, 20000);
        Oviparous v2 = new Dragon("Dragon", Gender.MALE, 15.0, 20000);
        System.out.println(v2.layEggs());
        Oviparous n = v2.layEggs();
        System.out.println(n);
//        System.out.println("\n suite \n");
//        System.out.println(v2.layEggs());
//        System.out.println(v1.getSexe());
//        System.out.println(v2.getSexe());
    }
}
