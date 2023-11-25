package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.consumable.food.Beefsteak;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Hunger;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Unicorn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    private Creature c;

    @BeforeEach
    void setUp() {
        c = new Unicorn("Lucie", Gender.MALE, 1000.0, 2.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void eatingIncreasesHungerState() {
        c.setHunger(0);
        c.eat(new Beefsteak());
        assertEquals(Hunger.MEDIUM.getState(), c.getHungerState());
    }

    @Test
    void shoutDoesNotThrowException() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        c.shout();
        assertEquals("Lucie fait hihihiha", outContent.toString().trim());
    }

    @Test
    void healingRemovesSickness() {
        c.setSick(true);
        c.healed();
        assertFalse(c.isSick());
    }

    @Test
    void toggleSleepingChangesSleepingState() {
        c.toggleSleeping();
        assertTrue(c.isSleeping());
    }

    @Test
    void agingIncreasesAge() {
        c.aging();
        assertEquals(Age.CHILD, c.getAge());
    }

    @Test
    void agingFourTimesResultsInDeath() {
        c.aging();
        c.aging();
        c.aging();
        c.aging();
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void getAgeReturnsCorrectAgeState() {
        assertEquals("Bébé", c.getAgeState());
    }

    @Test
    void getNameReturnsCorrectName() {
        assertEquals("Lucie", c.getName());
    }

    @Test
    void setNameChangesName() {
        c.setName("Autre nom");
        assertEquals("Autre nom", c.getName());
    }

    @Test
    void getSexeReturnsCorrectGender() {
        assertEquals(Gender.MALE, c.getSexe());
    }

    @Test
    void getWeightReturnsCorrectWeight() {
        assertEquals(1000.0, c.getWeight());
    }

    @Test
    void setWeightChangesWeight() {
        c.setWeight(200.0);
        assertEquals(200, c.getWeight());
    }

    @Test
    void getHeightReturnsCorrectHeight() {
        assertEquals(2.0, c.getHeight());
    }

    @Test
    void setHeightChangesHeight() {
        c.setHeight(3.0);
        assertEquals(3.0, c.getHeight());
    }

    @Test
    void getHungerStateReturnsCorrectHungerState() {
        assertEquals("Répu", c.getHungerState());
    }

    @Test
    void getHungerReturnsCorrectHungerValue() {
        assertEquals(Hunger.MAX.getValue(), c.getHunger());
    }

    @Test
    void setHungerChangesHungerState() {
        c.setHunger(Hunger.HUNGRY.getValue());
        assertEquals(Hunger.HUNGRY.getState(), c.getHungerState());
    }

    @Test
    void isSleepingReturnsCorrectSleepingState() {
        assertFalse(c.isSleeping());
    }

    @Test
    void setSleepingChangesSleepingState() {
        c.setSleeping(true);
        assertTrue(c.isSleeping());
    }

    @Test
    void isSickReturnsCorrectSicknessState() {
        assertFalse(c.isSick());
    }

    @Test
    void setSickChangesSicknessState() {
        c.setSick(true);
        assertTrue(c.isSick());
    }

    @Test
    void checkSickTwiceResultsInDeath() {
        c.setSick(true);
        c.setSick(true);
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void setAgeChangesAge() {
        c.setAge(Age.DEAD);
        assertEquals(Age.DEAD, c.getAge());
    }

    @Test
    void toStringIndentationIsCorrect() {
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

    @Test
    void fertilizableReturnsCorrectCreatureWhenConditionsAreMet() {
        Creature other = new Unicorn("Other", Gender.FEMALE, 1000.0, 2.0);
        assertEquals(other, c.fertilizable(other));
    }

    @Test
    void fertilizableReturnsNullWhenOneCreatureIsPregnant() {
        Creature other = new Unicorn("Other", Gender.FEMALE, 1000.0, 2.0);
        c.setPregnant(true);
        assertNull(c.fertilizable(other));
    }

    @Test
    void toggleSleepingDoesNotChangeSleepingStateWhenSick() {
        c.setSick(true);
        c.toggleSleeping();
        assertFalse(c.isSleeping());
    }

    @Test
    void eatDoesNotIncreaseHungerWhenAlreadySatisfied() {
        c.setHunger(Hunger.MAX.getValue());
        c.eat(new Beefsteak());
        assertEquals(Hunger.MAX.getState(), c.getHungerState());
    }

    @Test
    void eatDoesNotIncreaseHungerWhenSleeping() {
        c.setSleeping(true);
        c.eat(new Beefsteak());
        assertEquals(Hunger.MAX.getState(), c.getHungerState());
    }
}