package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.consumable.food.Beefsteak;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Hunger;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Unicorn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    private Creature c;

    @BeforeEach
    void setUp() {
        c = new Unicorn("Lucie", Gender.MALE, 1000.0, 2.0);
    }

    @Test
    void isEatWorking() {
        c.setHunger(0);
        c.eat(new Beefsteak());
        assertEquals(Hunger.MEDIUM.getState(), c.getHungerState());
    }

    @Test
    void isShoutWorking() {
        c.shout();
    }

    @Test
    void isHealedWorking() {
        c.setSick(true);
        c.healed();
        assertFalse(c.isSick());
    }

    @Test
    void isToggleSleepingWorking() {
        c.toggleSleeping();
        assertTrue(c.isSleeping());
    }

    @Test
    void isAgingWorking() {
        c.aging();
        assertEquals(Age.CHILD, c.getAge());
    }

    @Test
    void isAgingToDeathWorking() {
        c.aging();
        c.aging();
        c.aging();
        c.aging();
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void getAge() {
        assertEquals("Bébé", c.getAgeState());
    }

    @Test
    void getName() {
        assertEquals("Lucie", c.getName());
    }

    @Test
    void setName() {
        c.setName("Autre nom");
        assertEquals("Autre nom", c.getName());
    }

    @Test
    void getSexe() {
        assertEquals(Gender.MALE, c.getSexe());
    }

    @Test
    void getWeight() {
        assertEquals(1000.0, c.getWeight());
    }

    @Test
    void setWeight() {
        c.setWeight(200.0);
        assertEquals(200, c.getWeight());
    }

    @Test
    void getHeight() {
        assertEquals(2.0, c.getHeight());
    }

    @Test
    void setHeight() {
        c.setHeight(3.0);
        assertEquals(3.0, c.getHeight());
    }

    @Test
    void getHungerState() {
        assertEquals("Répu", c.getHungerState());
    }

    @Test
    void getHunger() {
        assertEquals(Hunger.MAX.getValue(), c.getHunger());
    }

    @Test
    void setHunger() {
        c.setHunger(Hunger.HUNGRY.getValue());
        assertEquals(Hunger.HUNGRY.getState(), c.getHungerState());
    }

    @Test
    void isSleeping() {
        assertFalse(c.isSleeping());
    }

    @Test
    void setSleeping() {
        c.setSleeping(true);
        assertTrue(c.isSleeping());
    }

    @Test
    void isSick() {
        assertFalse(c.isSick());
    }

    @Test
    void setSick() {
        c.setSick(true);
        assertTrue(c.isSick());
    }

    @Test
    void checkSick() {
        c.setSick(true);
        c.setSick(true);
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void setAge() {
        c.setAge(Age.DEAD);
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void testToString() {
        assertEquals("""
                <-/ Unicorn \\->
                --------------
                Nom: Lucie
                Sexe: Male
                Age: Bébé
                Cri: hihihiha
                Poids: 1000.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s
                """, c.toString());
    }
}