package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.*;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

import java.util.Random;

public class Dragon extends Oviparous implements Flying, Runner, Swimmer, Rebirth {
    public Dragon(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "graou");
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " *est entrain de voler*");
    }

    @Override
    public void run() {
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
    public void rebirth() {
        if (getAge() == Age.DEAD) {
            setAge(Age.BABY);
        }
    }

    @Override
    public Oviparous eggsHatch(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 7.0 + (12.0 - 7.0) * random.nextDouble();
        double babyHeight = 0.9 + (1.20 - 0.9) * random.nextDouble();

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Dragon(getName(), babySexe, babyWeight, babyHeight);
    }
}