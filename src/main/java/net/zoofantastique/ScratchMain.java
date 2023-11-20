package net.zoofantastique;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Creature;
import net.zoofantastique.controller.creature.composition.Dragon;
import net.zoofantastique.controller.creature.composition.Mermaid;
import net.zoofantastique.controller.creature.consumable.food.Beefsteak;
import net.zoofantastique.controller.creature.oviparous.Oviparous;
import net.zoofantastique.controller.creature.viviparous.Viviparous;

public class ScratchMain {
    public static void main(String[] args) {
        Oviparous mDragon = new Dragon("Bite Molle", Gender.MALE, 1000.0, 2.0);
        Oviparous fDragon = new Dragon("Cuisine", Gender.FEMALE, 1500.0, 3.0);
        Oviparous jeSuisGay = new Dragon("Jaimelabite", Gender.MALE, 1200.0, 1.5);

        Oviparous babyDragon = mDragon.layEggs(fDragon);
        System.out.println(babyDragon);
    }
}
