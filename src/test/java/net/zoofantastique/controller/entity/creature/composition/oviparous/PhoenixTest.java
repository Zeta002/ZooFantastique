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
    private Phoenix Phoenix;

    @BeforeEach
    void setUp() {
        Phoenix = new Phoenix("Test Phoenix", Gender.FEMALE, 10.0, 1.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void flyPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Phoenix.fly();
        assertEquals("Test Phoenix *est entrain de voler*", outContent.toString().trim());
    }

    @Test
    void setAgeResetsAgeWhenDead() {
        Phoenix.setAge(Age.DEAD);
        assertEquals(Age.BABY, Phoenix.getAge());
    }

    @Test
    void eggsHatchReturnsBabyDragon() {
        Phoenix baby = Phoenix.eggsHatch();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void rebirthResetsAgeWhenDead() {
        Phoenix.setAge(Age.DEAD);
        Phoenix.rebirth();
        assertEquals(Age.BABY, Phoenix.getAge());
    }

    @Test
    void rebirthDoesNotResetAgeWhenAlive() {
        Phoenix.setAge(Age.ADULT);
        Phoenix.rebirth();
        assertEquals(Age.ADULT, Phoenix.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(Phoenix.eggsHatch().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomWeight() {
        Set<Double> weights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            weights.add(Phoenix.eggsHatch().getWeight());
        }
        assertTrue(weights.stream().anyMatch(weight -> weight > 50 && weight < 80));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomHeight() {
        Set<Double> heights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            heights.add(Phoenix.eggsHatch().getHeight());
        }
        assertTrue(heights.stream().anyMatch(height -> height > 2 && height < 5));
    }
}
