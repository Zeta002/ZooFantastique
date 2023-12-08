package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        dragon = new Dragon("Test Dragon", Gender.FEMALE);
        dragon.setHeight(1.0);
        dragon.setWeight(10.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void flyPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        dragon.fly();
        assertEquals("Test Dragon *est entrain de voler*", outContent.toString().trim());
    }

    @Test
    void runPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        dragon.running();
        assertEquals("Test Dragon *cours*", outContent.toString().trim());
    }

    @Test
    void swimPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        dragon.swim();
        assertEquals("Test Dragon *nage*", outContent.toString().trim());
    }

    @Test
    void setAgeResetsAgeWhenDead() {
        dragon.setAge(Age.DEAD);
        assertEquals(Age.BABY, dragon.getAge());
    }

    @Test
    void eggsHatchReturnsBabyDragon() {
        Dragon baby = dragon.eggsHatch();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void rebirthResetsAgeWhenDead() {
        dragon.setAge(Age.DEAD);
        dragon.rebirth();
        assertEquals(Age.BABY, dragon.getAge());
    }

    @Test
    void rebirthDoesNotResetAgeWhenAlive() {
        dragon.setAge(Age.ADULT);
        dragon.rebirth();
        assertEquals(Age.ADULT, dragon.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(dragon.eggsHatch().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }
}
