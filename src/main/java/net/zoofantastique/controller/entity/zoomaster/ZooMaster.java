package net.zoofantastique.controller.entity.zoomaster;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.Alive;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;

/**
 * Classe ZooMaster, hérite de la classe Alive.
 * Cette classe représente le personnage principal du jeu, le joueur.
 */
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

    // Méthodes

    // TODO : se mettre d'accord sur où mettre les méthodes de MenuZooMaster, actuellement on les utilises à la place de celle-ci
    public <T extends Creature> void displayEnclosure(Enclosure<T> enclosure){
        System.out.println(enclosure);
    }

    public <T extends Creature> void maintenanceEnclosure(Enclosure<T> enclosure){
        enclosure.maintenance();
    }

    public <T extends Creature> void feeding(Enclosure<T> enclosure, Food food, T creature){
        enclosure.feedCreature(food, creature);
    }

    // TODO : doc
    public <T extends Creature> void transferTo(Enclosure<T> oldEnclosure, Enclosure<T> newEnclosure, T creature){
        if (!oldEnclosure.getCreatureType().equals(newEnclosure.getCreatureType())){
            System.err.println("Les enclos ne sont pas du même type!");
            return;
        }
        if (!oldEnclosure.getListCreature().contains(creature)){
            System.err.println("La créature n'est pas dans l'enclos!");
            return;
        }
        newEnclosure.addCreature(creature);
        oldEnclosure.removeCreature(creature);
    }
}

