package net.zoofantastique.controller.entity.creature.composition.oviparous;

/**
 * Interface Oviparous qui représente une créature ovipare dans un zoo.
 * Une créature ovipare est une créature qui pond des œufs, qui a une durée d'incubation et qui peut faire éclore ses œufs.
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


