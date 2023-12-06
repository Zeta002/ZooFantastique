package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.Random;

/**
 * Classe abstraite Oviparous qui représente une créature ovipare dans un zoo.
 * Une créature ovipare est une créature qui pond des œufs, qui a une durée d'incubation et qui peut faire éclore ses œufs.
 * Cette classe étend la classe Creature.
 */
public interface Oviparous {
    // Attributs
    int incubationDuration = 30;

    /**
     * Retourne une instance de bébé creature ovipare.
     *
     * @return Un nouveau bébé ovipare.
     */
    Oviparous eggsHatch();
}


