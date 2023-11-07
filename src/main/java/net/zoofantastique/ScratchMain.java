package net.zoofantastique;

import net.zoofantastique.controller.creature.Creature;

public class ScratchMain {
    public static void main(String[] args) {
        Creature creature = new Creature("Abdoul", "zhomme", 15.2, 52.3);
        creature.setHunger(3);
        System.out.println(creature.getHunger().getHunger());
        System.out.println(creature.getHunger().getState());
    }
}
