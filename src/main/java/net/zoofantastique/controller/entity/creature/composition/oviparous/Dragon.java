package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.*;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.zoofantastique.utils.Utils.getRandomDoubleInRange;

/**
 * Classe Dragon qui représente un dragon dans un zoo.
 * Un dragon est une créature ovipare qui peut voler, courir, nager et renaître.
 * Cette classe étend la classe Creature et implémente les interfaces Oviparous, Flying, Runner, Swimmer et Rebirth.
 */
public class Dragon extends Creature implements Oviparous, Flying, Runner, Swimmer, Rebirth {

    public Dragon(String name, Gender sexe) {
        super(name, sexe, "graou");
        setMinHeight(new ArrayList<>(List.of(0.3, 1.2, 4.5, 5.5, 5.8)));
        setMaxHeight(new ArrayList<>(List.of(1.2, 4.5, 5.5, 5.8, 6.5)));
        setMinWeight(new ArrayList<>(List.of(60.0, 500.0, 1500.0, 2500.0, 3500.0)));
        setMaxWeight(new ArrayList<>(List.of(120.0, 1000.0, 2200.0, 3000.0, 4000.0)));

        setAgeScale(120);
        setDimHunger(50);

        calcSizeAndWeight();
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " *est entrain de voler*");
    }

    @Override
    public void running() {
        System.out.println(super.getName() + " *cours*");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    @Override
    public void aging() {
        super.aging();
        rebirth();
    }

    @Override
    public void setAge(Age age) {
        super.setAge(age);
        rebirth();
    }

    @Override
    public void haveToGoToTheHell() {
        setHeight(getRandomDoubleInRange(0.3, 1.2));
        setWeight(getRandomDoubleInRange(30, 120));
        rebirth();
    }

    @Override
    public void rebirth() {
        if (getAge() == Age.DEAD) {
            setAge(Age.BABY);
            calcSizeAndWeight();
        }
    }

    // TODO : doc
    @Override
    public Dragon eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Dragon(getName(), babySexe);
    }
}