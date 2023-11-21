package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

/**
 * Classe représentant une volière.
 */
public class AviaryEnclosure extends Enclosure {

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

    /**
     * Retourne la hauteur du toit de la volière.
     *
     * @return la hauteur du toit de la volière en mètres
     */
    public double getRoofHeight() {
        return roofHeight;
    }

    /**
     * Définit la hauteur du toit de la volière.
     *
     * @param roofHeight la nouvelle hauteur du toit de la volière en mètres
     */
    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

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