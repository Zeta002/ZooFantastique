package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

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
     * @param basinDepth     la profondeur du bassin en mètres
     *
     * <p>Si la profondeur du bassin est <= 80 mètres, effectuer une maintenance et augmenter la salinité du bassin.</p>
     * <p>Si la profondeur du bassin est > 80 mètres et <= 100 mètres, augmenter également la salinité du bassin.</p>
     * <p>Si la profondeur du bassin est > 100 mètres et <= 120 mètres, augmenter également la salinité du bassin.</p>
     * <p>Si la profondeur du bassin est >= 120 mètres, augmenter également la salinité du bassin.</p>
     * <p>Si aucune de ces conditions n'est remplie, afficher la propreté actuelle de l'aquarium.</p>
     */
    public void maintenance(double basinDepth) {
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
        } else if (basinDepth >= 120) {
            // TODO
            basinSalinity.inscreaseSalinity();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + basinSalinity.getValue() + ".");
        } else {
            System.out.println(getClass().getSimpleName() + " : " + getName() + " reste " + basinSalinity.getValue() + ".");
        }
    }
}
