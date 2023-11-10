package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.composition.Unicorn;

public class ScratchMain {
    public static void main(String[] args) {
//        Creature c1 = new Creature("Abdoul", "zhomme", 15.2, 52.3);
//        c1.setHunger(3);
//        System.out.println(c1.getHunger().getHunger());
//        System.out.println(c1.getHunger().getState());

        Creature c2 = new Unicorn("Unicorn", Gender.MALE, 720.0, 2);
        System.out.println(c2.getAgeState());
    }
}
