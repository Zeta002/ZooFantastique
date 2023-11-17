package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    @org.junit.jupiter.api.Test
    void isEatWorking() {
        // TODO
    }

    @org.junit.jupiter.api.Test
    void isShoutWorking() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.shout();
    }

    @org.junit.jupiter.api.Test
    void isHealedWorking() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setSick(true);
        c.healed();
        assertFalse(c.isSick());
    }

    @org.junit.jupiter.api.Test
    void isToggleSleepingWorking() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.toggleSleeping();
        assertTrue(c.isSleeping());
    }

    @org.junit.jupiter.api.Test
    void isAgingWorking() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.aging();
        assertEquals(Age.CHILD, c.getAge());
    }

    @org.junit.jupiter.api.Test
    void isAgingToDeathWorking() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.aging();
        c.aging();
        c.aging();
        c.aging();
        assertEquals(Age.DEAD, c.getAge());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("Bébé", c.getAgeState());
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
        assertEquals(Gender.MALE, c.getSexe());
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

    @org.junit.jupiter.api.Test
    void checkSick() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setSick(true);
        c.setSick(true);
        assertEquals(Age.DEAD, c.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        c.setAge(Age.DEAD);
        assertEquals(Age.DEAD, c.getAge());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Creature c = new Unicorn("Test", Gender.MALE, 1000.0, 2.0);
        assertEquals("""
                <-/ Unicorn \\->
                --------------
                Nom: Test
                Sexe: Male
                Age: Bébé
                Cri: hihihiha
                Poids: 1000.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s""", c.toString());
    }
}