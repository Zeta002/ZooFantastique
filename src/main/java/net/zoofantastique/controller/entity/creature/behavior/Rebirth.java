package net.zoofantastique.controller.entity.creature.behavior;

public interface Rebirth {
    /**
     * Méthode par défaut pour faire renaitre une créature.
     * Affiche un message indiquant que la créature renait.
     */
    default void rebirth() {
        System.out.println("La créature renait.");
    }
}
