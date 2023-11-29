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

class LycanthropeTest {
    private Lycanthrope Lycanthrope;

    @BeforeEach
    void setUp() {
        Lycanthrope = new Lycanthrope("Test Lycanthrope", Gender.FEMALE, 10.0, 1.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void runPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Lycanthrope.run();
        assertEquals("Test Lycanthrope *cours*", outContent.toString().trim());
    }

    @Test
    void eggsHatchReturnsBabyKraken() {
        Lycanthrope baby = Lycanthrope.giveBirth();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(Lycanthrope.giveBirth().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomWeight() {
        Set<Double> weights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            weights.add(Lycanthrope.giveBirth().getWeight());
        }
        assertTrue(weights.stream().anyMatch(weight -> weight > 1 && weight < 4));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomHeight() {
        Set<Double> heights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            heights.add(Lycanthrope.giveBirth().getHeight());
        }
        assertTrue(heights.stream().anyMatch(height -> height > 0.2 && height < 0.5));
    }
}