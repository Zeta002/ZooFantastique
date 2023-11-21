package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

/**
 * Classe AviaryEnclosure qui représente une volière dans un zoo.
 * Une volière est un type d'enclos qui a une hauteur de toit en plus des attributs d'un enclos.
 * Cette classe étend la classe Enclosure.
 */
public class AviaryEnclosure extends Enclosure {
    // Attributs

    /**
     * La hauteur du toit de la volière.
     */
    private double roofHeight;

    /**
     * Construit un nouvel AviaryEnclosure avec les paramètres spécifiés.
     *
     * @param name       le nom de la volière
     * @param surface    la surface de la volière en mètres carrés
     * @param roofHeight la hauteur du toit de la volière en mètres
     * @param max        le nombre maximum de créatures qui peuvent être logées dans la volière
     */
    public AviaryEnclosure(String name, double surface, double roofHeight, int max) {
        super(name, surface, max);
        this.roofHeight = roofHeight;
    }

    /**
     * Construit un nouvel AviaryEnclosure avec les paramètres spécifiés.
     *
     * @param name         le nom de la volière
     * @param surface      la surface de la volière en mètres carrés
     * @param roofHeight   la hauteur du toit de la volière en mètres
     * @param max          le nombre maximum de créatures qui peuvent être logées dans la volière
     * @param listCreature la liste des créatures actuellement logées dans la volière
     */
    public AviaryEnclosure(String name, double surface, double roofHeight, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
        this.roofHeight = roofHeight;
    }

    // Getter et setter

    public double getRoofHeight() {
        return roofHeight;
    }
    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    // Méthodes

    /**
     * Méthode pour effectuer la maintenance de la volière.
     * Affiche un message indiquant que la volière est en maintenance.
     * En fonction de la hauteur du toit, effectue une opération de nettoyage et affiche un message indiquant que la volière est maintenant propre.
     * Si la hauteur du toit ne correspond à aucun des intervalles définis, affiche un message indiquant que la volière reste dans son état de propreté actuel.
     *
     * @param roofHeight La hauteur du toit de la volière en mètres.
     */
    public void maintenance(double roofHeight) {
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        // TODO : thread d'un temps aléatoire dans une intervalle donné, plus la hauteur du toit est grande, plus le temps est long
        if (roofHeight <= 20) {
            // TODO
            getCleanness().clean();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
        } else if (roofHeight > 20 && roofHeight <= 40) {
            // TODO
            getCleanness().clean();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
        } else if (roofHeight > 40 && roofHeight <= 60) {
            // TODO
            getCleanness().clean();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
        } else if (roofHeight > 60) {
            // TODO
            getCleanness().clean();
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
        } else {
            System.out.println(getClass().getSimpleName() + " : " + getName() + " reste " + getCleanness().getValue() + ".");
        }
    }
}