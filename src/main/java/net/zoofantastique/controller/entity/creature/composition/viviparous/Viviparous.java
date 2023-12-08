package net.zoofantastique.controller.entity.creature.composition.viviparous;

/**
 * Interface Viviparous qui représente une créature vivipare dans un zoo.
 * Une créature vivipare est une créature qui donne naissance à des jeunes vivants, qui a une durée de gestation et qui peut initier une grossesse.
 */
public interface Viviparous {
    // Attributs
    int gestationDuration = 30;

    /**
     * Retourne une instance de bébé creature vivipare.
     *
     * @return Un nouveau bébé vivipare.
     */
    Viviparous giveBirth();
}
