package net.zoofantastique.controller.entity.zoomaster;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.enclosure.Enclosure;
import net.zoofantastique.controller.entity.Alive;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;

public class ZooMaster extends Alive {
    /**
     * Constructeur de la classe Alive avec nom, sexe et âge.
     *
     * @param name le nom de la créature.
     * @param sexe le sexe de la créature, peut être Male ou Femelle.
     * @param age  l'âge de la créature.
     */
    public ZooMaster(String name, Gender sexe, Age age){
        super(name, sexe, age);
    }

    public void displayEnclosure(Enclosure enclosure){
        System.out.println(enclosure);
    }

    public void maintenanceEnclosure(Enclosure enclosure){
        enclosure.maintenance();
    }

    public void feeding(Enclosure enclosure, Food food, Creature creature){
        enclosure.feedCreature(food, creature);
    }

    public void tranferTo(Enclosure oldEnclosure, Enclosure newEnclosure, Creature creature){
        if (oldEnclosure.getListCreature().contains(creature)){
            newEnclosure.addCreature(creature);
            oldEnclosure.removeCreature(creature);
        } else {
            System.err.println("La créature n'est pas dans l'enclos!");
        }
    }



}

