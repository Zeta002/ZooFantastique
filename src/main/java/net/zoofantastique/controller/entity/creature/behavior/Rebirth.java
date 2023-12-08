package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Interface Rebirth représentant le comportement de renaissance d'une créature.
 */
public interface Rebirth {
    /**
     * Méthode par défaut pour faire renaitre une créature.
     * Affiche un message indiquant que la créature renait.
     */
    default void rebirth() {
        System.out.println("La créature renait.");
    }
}
