package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.consumable.Beefsteak;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    @org.junit.jupiter.api.Test
    void isEatCorrect() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setHunger(8);
        c.eat(new Beefsteak());
        System.out.println(c.getHungerState());
    }

    @org.junit.jupiter.api.Test
    void shout() {
    }

    @org.junit.jupiter.api.Test
    void healed() {
    }

    @org.junit.jupiter.api.Test
    void toggleSleeping() {
    }

    @org.junit.jupiter.api.Test
    void aging() {
    }

    @org.junit.jupiter.api.Test
    void getAge() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void getSexe() {
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @org.junit.jupiter.api.Test
    void setHeight() {
    }

    @org.junit.jupiter.api.Test
    void getHungerState() {
    }

    @org.junit.jupiter.api.Test
    void getHunger() {
    }

    @org.junit.jupiter.api.Test
    void setHunger() {
    }

    @org.junit.jupiter.api.Test
    void isSleeping() {
    }

    @org.junit.jupiter.api.Test
    void setSleeping() {
    }

    @org.junit.jupiter.api.Test
    void isSick() {
    }

    @org.junit.jupiter.api.Test
    void setSick() {
    }
}