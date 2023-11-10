package net.zoofantastique.controller.creature.behavior;

public interface Flying {
    /**
     * permet de voler, la method par défaut permet à n'importe quoi de voler
     * sans préciser le nom, est souvent @Override dans des classes pour préciser
     * le nom de l'espèce de l'animal volant
     *
     * @author Angelo P.
     */
    default void fly() {
        System.out.println("*vole dans les air*");
    }
}
