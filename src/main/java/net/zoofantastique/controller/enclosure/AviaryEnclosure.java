package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class AviaryEnclosure extends Enclosure {

    private double roofHeight; // hauteur du toit

    public AviaryEnclosure(String name, double surface, double roofHeight, int max) {
        super(name, surface, max);
        this.roofHeight = roofHeight;
    }

    public AviaryEnclosure(String name, double surface, double roofHeight, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
        this.roofHeight = roofHeight;
    }

    // Getter et Setter
    public double getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    // Méthodes
    public void maintenance(double roofHeight) {
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        // TODO : thread d'un temps aléatoire dans une intervalle donné
        // TODO : Avec la réponse par mail du prof, adapté le code
        if (roofHeight > 20) {
            // TODO : thread d'un temps donné
            return;
        }
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue());
    }
}
