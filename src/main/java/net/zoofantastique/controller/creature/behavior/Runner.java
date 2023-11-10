package net.zoofantastique.controller.creature.behavior;

public interface Runner {
    /**
     * permet de courir, la method par défaut permet à n'importe quoi de courir
     * sans préciser le nom, est souvent @Override dans des classes pour préciser
     * le nom de l'espèce de l'animal courant
     *
     * @author Angelo P.
     */
    default void run() {
        System.out.println("*cours*");
    }
}
