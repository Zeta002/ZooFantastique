package net.zoofantastique;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Pack;
import net.zoofantastique.controller.entity.creature.behavior.Pair;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;

public class ScratchMain {
    public static void main(String[] args) {
        Pack p = new Pack("meute de test", new Pair<>(new Lycanthrope("Le male", Gender.MALE, 2, 2), new Lycanthrope("La femelle", Gender.FEMALE, 2, 2)));
        System.out.println(p);
    }
}
