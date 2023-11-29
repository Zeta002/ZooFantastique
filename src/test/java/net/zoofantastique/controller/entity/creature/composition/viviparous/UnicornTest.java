package net.zoofantastique.controller.entity.creature.composition.viviparous;

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

class UnicornTest {
    private Unicorn Unicorn;

    @BeforeEach
    void setUp() {
        Unicorn = new Unicorn("Test Unicorn", Gender.FEMALE, 10.0, 1.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void runPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Unicorn.run();
        assertEquals("Test Unicorn *cours*", outContent.toString().trim());
    }

    @Test
    void eggsHatchReturnsBabyKraken() {
        Unicorn baby = Unicorn.giveBirth();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(Unicorn.giveBirth().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomWeight() {
        Set<Double> weights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            weights.add(Unicorn.giveBirth().getWeight());
        }
        assertTrue(weights.stream().anyMatch(weight -> weight > 10 && weight < 20));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomHeight() {
        Set<Double> heights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            heights.add(Unicorn.giveBirth().getHeight());
        }
        assertTrue(heights.stream().anyMatch(height -> height > 0.2 && height < 0.4));
    }
}