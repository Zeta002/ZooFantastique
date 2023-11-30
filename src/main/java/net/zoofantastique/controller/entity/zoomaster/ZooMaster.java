package net.zoofantastique.controller.entity.zoomaster;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.enclosure.composition.Enclosure;
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


    public <T extends Creature> void displayEnclosure(Enclosure<T> enclosure){
        System.out.println(enclosure);
    }
    public <T extends Creature> void maintenanceEnclosure(Enclosure<T> enclosure){
        enclosure.maintenance();
    }
    public <T extends Creature> void feeding(Enclosure<T> enclosure, Food food, T creature){
        enclosure.feedCreature(food, creature);
    }
    public <T extends Creature> void tranferTo(Enclosure<T> oldEnclosure, Enclosure<T> newEnclosure, T creature){
        if (oldEnclosure.getListCreature().contains(creature)){
            newEnclosure.addCreature(creature);
            oldEnclosure.removeCreature(creature);
        } else {
            System.err.println("La créature n'est pas dans l'enclos!");
        }
    }
}

