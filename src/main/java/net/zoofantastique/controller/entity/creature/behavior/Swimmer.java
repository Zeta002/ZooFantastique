package net.zoofantastique.controller.entity.creature.behavior;

public interface Swimmer {
    /**
     * Méthode par défaut pour faire nager une créature.
     * Affiche un message indiquant que la créature nage.
     */
    default void swim() {
        System.out.println("*nage*");
    }
}
