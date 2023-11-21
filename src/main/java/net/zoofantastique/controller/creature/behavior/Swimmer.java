package net.zoofantastique.controller.creature.behavior;

public interface Swimmer {
    /**
     * permet de nager, la method par défaut permet à n'importe quoi de nager
     * sans préciser le nom, est souvent @Override dans des classes pour préciser
     * le nom de l'espèce de l'animal nageant
     */
    default void swim() {
        System.out.println("*nage*");
    }
}
