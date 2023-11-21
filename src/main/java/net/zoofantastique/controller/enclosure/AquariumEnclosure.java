package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.creature.composition.Creature;

import java.util.ArrayList;

public class AquariumEnclosure extends Enclosure {

    private double basinDepth;
    private Salinity basinSalinity;

    public AquariumEnclosure(String name, double surface, double basinDepth, int max) {
        super(name, surface, max);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    public AquariumEnclosure(String name, double surface, double basinDepth, int max, ArrayList<Creature> listCreature) {
        super(name, surface, max, listCreature);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    public void maintenance(double basinDepth, Salinity basinSalinity) {
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        // TODO : thread d'un temps aléatoire dans une intervalle donné
        // TODO : Avec la réponse par mail du prof, adapté le code
        basinSalinity.inscreaseSalinity();
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue());
    }
}
