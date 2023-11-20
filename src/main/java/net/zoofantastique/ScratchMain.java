package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Dragon;
import net.zoofantastique.controller.creature.consumable.food.Beefsteak;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

public class ScratchMain {
    public static void main(String[] args) {
        Oviparous v = new Dragon("Cauchemar", Gender.MALE, 1000.0, 2.0);
        System.out.println(v);

        System.out.println(new Beefsteak());
    }
}
