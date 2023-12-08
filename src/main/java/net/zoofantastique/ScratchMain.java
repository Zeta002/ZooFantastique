package net.zoofantastique;

import net.zoofantastique.controller.entity.creature.behavior.CoupleAlpha;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Pack;
import net.zoofantastique.controller.entity.creature.behavior.Pair;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;
import net.zoofantastique.simulation.Simulation;
import net.zoofantastique.view.Game;

public class ScratchMain {
    public static void main(String[] args) {
//        Pack p = new Pack("meute de test", new Pair<>(new Lycanthrope("Le male", Gender.MALE, 2, 2), new Lycanthrope("La femelle", Gender.FEMALE, 2, 2)));
//        System.out.println(p);
        Game game = new Game();
        game.start();

    }
}
