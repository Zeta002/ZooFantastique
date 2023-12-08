package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Interface Runner représentant le comportement de course d'une créature.
 */
public interface Runner {
    /**
     * Méthode par défaut pour faire courir une créature.
     * Affiche un message indiquant que la créature court.
     */
    default void run() {
        System.out.println("*cours*");
    }
}
