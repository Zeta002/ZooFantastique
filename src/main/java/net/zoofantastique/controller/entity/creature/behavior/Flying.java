package net.zoofantastique.controller.entity.creature.behavior;

/**
 * Interface Flying représentant le comportement de vol d'une créature.
 */
public interface Flying {
    /**
     * Méthode par défaut pour faire voler une créature.
     * Affiche un message indiquant que la créature vole dans les airs.
     */
    default void fly() {
        System.out.println("*vole dans les air*");
    }
}
