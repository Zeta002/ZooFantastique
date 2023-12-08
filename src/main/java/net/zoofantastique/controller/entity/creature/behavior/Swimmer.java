package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Interface Swimmer représentant le comportement de nage d'une créature.
 */
public interface Swimmer {
    /**
     * Méthode par défaut pour faire nager une créature.
     * Affiche un message indiquant que la créature nage.
     */
    default void swim() {
        System.out.println("*nage*");
    }
}
