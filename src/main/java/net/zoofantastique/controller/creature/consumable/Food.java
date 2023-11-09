package net.zoofantastique.controller.creature.consumable;

public interface Food {
    // Attributs
    // Nom de l'aliment
    String name = null;
    // Valeur nutritionel
    int value = 0;

    /**
     * getter du nom de l'aliment
     *
     * @author Angelo P.
     * @return nom de l'aliment
     */
    String getName();

    /**
     * getter de la valeur nutritionel de l'aliment
     *
     * @author Angelo P.
     * @return valeur nutritionel de l'aliment
     */
    int getValue();
}
