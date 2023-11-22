package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

/**
 * Classe AquariumEnclosure qui représente un aquarium dans un zoo.
 * Un aquarium est un type d'enclos qui a une profondeur de bassin et une salinité de bassin en plus des attributs d'un enclos.
 * Cette classe étend la classe Enclosure.
 */
public class AquariumEnclosure extends Enclosure {
    /**
     * La profondeur du bassin dans l'aquarium en mètres.
     */
    private double basinDepth;

    /**
     * La salinité du bassin dans l'aquarium.
     */
    private Salinity basinSalinity;

    /**
     * Construit un nouvel AquariumEnclosure avec les paramètres spécifiés.
     *
     * @param name       le nom de l'aquarium
     * @param surface    la surface de l'aquarium en mètres carrés
     * @param basinDepth la profondeur du bassin dans l'aquarium en mètres
     * @param max        le nombre maximum de créatures qui peuvent être logées dans l'aquarium
     *
     * <p>La salinité du bassin est initialisée à BRACKISHWATER.</p>
     */
    public AquariumEnclosure(String name, double surface, double basinDepth, int max) {
        super(name, surface, max);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    /**
     * Construit un nouvel AquariumEnclosure avec les paramètres spécifiés.
     *
     * @param name         le nom de l'aquarium
     * @param surface      la surface de l'aquarium en mètres carrés
     * @param basinDepth   la profondeur du bassin dans l'aquarium en mètres
     * @param max          le nombre maximum de créatures qui peuvent être logées dans l'aquarium
     * @param listCreature la liste des créatures actuellement logées dans l'aquarium
     *
     * <p>La salinité du bassin est initialisée à BRACKISHWATER.</p>
     */
    public AquariumEnclosure(String name, double surface, double basinDepth, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    /**
     * Effectue une maintenance sur l'aquarium en fonction de la profondeur du bassin.
     *
     * @param basinDepth la profondeur du bassin en mètres
     *
     * <p>Si l'aquarium est vide, un message est affiché et la méthode est terminée.</p>
     * <p>Si l'aquarium n'est pas vide, un message indiquant que l'aquarium est en maintenance est affiché.</p>
     * <p>Ensuite, en fonction de la profondeur du bassin :</p>
     * <ul>
     *   <li>Si la profondeur est <= 80 mètres, la salinité du bassin est augmentée.</li>
     *   <li>Si la profondeur est > 80 mètres et <= 100 mètres, la salinité du bassin est augmentée.</li>
     *   <li>Si la profondeur est > 100 mètres et <= 120 mètres, la salinité du bassin est augmentée.</li>
     *   <li>Si la profondeur est > 120 mètres, la salinité du bassin est augmentée.</li>
     * </ul>
     * <p>Après chaque augmentation de la salinité, un message indiquant la nouvelle salinité du bassin est affiché.</p>
     * <p>Si aucune des conditions de profondeur n'est remplie, un message indiquant la salinité actuelle du bassin est affiché.</p>
     */
    public void maintenance(double basinDepth) {
        if (getListCreature().isEmpty()) {
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est vide.");
            return;
        }
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        // TODO : thread d'un temps aléatoire dans une intervalle donné plus la profondeur du bassin est grande, plus le temps est long
        if (basinDepth <= 80) {
            // TODO
            basinSalinity.inscreaseSalinity();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + basinSalinity.getValue() + ".");
        } else if (basinDepth > 80 && basinDepth <= 100) {
            // TODO
            basinSalinity.inscreaseSalinity();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + basinSalinity.getValue() + ".");
        } else if (basinDepth > 100 && basinDepth <= 120) {
            // TODO
            basinSalinity.inscreaseSalinity();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + basinSalinity.getValue() + ".");
        } else if (basinDepth > 120) {
            // TODO
            basinSalinity.inscreaseSalinity();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + basinSalinity.getValue() + ".");
        } else {
            System.out.println(getClass().getSimpleName() + " : " + getName() + " reste " + basinSalinity.getValue() + ".");
        }
    }
}
