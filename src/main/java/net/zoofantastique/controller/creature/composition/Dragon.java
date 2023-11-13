package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.*;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

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
}