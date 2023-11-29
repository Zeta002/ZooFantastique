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

class MegalodonTest {
    private Megalodon Megalodon;

    @BeforeEach
    void setUp() {
        Megalodon = new Megalodon("Test Megalodon", Gender.FEMALE, 10.0, 1.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void swimPrintsExpectedOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Megalodon.swim();
        assertEquals("Test Megalodon *nage*", outContent.toString().trim());
    }

    @Test
    void eggsHatchReturnsBabyKraken() {
        Megalodon baby = Megalodon.eggsHatch();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(Megalodon.eggsHatch().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomWeight() {
        Set<Double> weights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            weights.add(Megalodon.eggsHatch().getWeight());
        }
        assertTrue(weights.stream().anyMatch(weight -> weight > 90 && weight < 130));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomHeight() {
        Set<Double> heights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            heights.add(Megalodon.eggsHatch().getHeight());
        }
        assertTrue(heights.stream().anyMatch(height -> height > 5 && height < 7));
    }
}