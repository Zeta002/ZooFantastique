package net.zoofantastique.controller.creature.behavior;

public interface Runner {
    /**
     * Méthode par défaut pour faire courir une créature.
     * Affiche un message indiquant que la créature court.
     */
    default void run() {
        System.out.println("*cours*");
    }
}
