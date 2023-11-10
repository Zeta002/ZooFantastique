package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;
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
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("Bébé", c.getAge());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("Test", c.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setName("Autre nom");
        assertEquals("Autre nom", c.getName());
    }

    @org.junit.jupiter.api.Test
    void getSexe() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("Male", c.getSexe());
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals(1000.0, c.getWeight());
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setWeight(200.0);
        assertEquals(200, c.getWeight());
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals(2.0, c.getHeight());
    }

    @org.junit.jupiter.api.Test
    void setHeight() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setHeight(3.0);
        assertEquals(3.0, c.getHeight());
    }

    @org.junit.jupiter.api.Test
    void getHungerState() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("Répu", c.getHungerState());
    }

    @org.junit.jupiter.api.Test
    void getHunger() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals(Hunger.SATISFIED, c.getHunger());
    }

    @org.junit.jupiter.api.Test
    void setHunger() {
        // TODO
    }

    @org.junit.jupiter.api.Test
    void isSleeping() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertFalse(c.isSleeping());
    }

    @org.junit.jupiter.api.Test
    void setSleeping() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setSleeping(true);
        assertTrue(c.isSleeping());
    }

    @org.junit.jupiter.api.Test
    void isSick() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertFalse(c.isSick());
    }

    @org.junit.jupiter.api.Test
    void setSick() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setSick(true);
        assertTrue(c.isSick());
    }
}