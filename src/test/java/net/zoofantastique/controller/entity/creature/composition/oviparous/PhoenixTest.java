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

class PhoenixTest {
    private Phoenix phoenix;

    @BeforeEach
    void setUp() {
        phoenix = new Phoenix("Test Phoenix", Gender.FEMALE);
        phoenix.setHeight(1.0);
        phoenix.setWeight(10.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void flyPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        phoenix.fly();
        assertEquals("Test Phoenix *est entrain de voler*", outContent.toString().trim());
    }

    @Test
    void setAgeResetsAgeWhenDead() {
        phoenix.setAge(Age.DEAD);
        assertEquals(Age.BABY, phoenix.getAge());
    }

    @Test
    void eggsHatchReturnsBabyDragon() {
        Phoenix baby = phoenix.eggsHatch();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void rebirthResetsAgeWhenDead() {
        phoenix.setAge(Age.DEAD);
        phoenix.rebirth();
        assertEquals(Age.BABY, phoenix.getAge());
    }

    @Test
    void rebirthDoesNotResetAgeWhenAlive() {
        phoenix.setAge(Age.ADULT);
        phoenix.rebirth();
        assertEquals(Age.ADULT, phoenix.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(phoenix.eggsHatch().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }
}
