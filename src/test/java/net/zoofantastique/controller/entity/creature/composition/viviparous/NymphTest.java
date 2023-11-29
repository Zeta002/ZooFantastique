package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NymphTest {
    private Nymph Nymph;

    @BeforeEach
    void setUp() {
        Nymph = new Nymph("Test Nymph", Gender.FEMALE, 10.0, 1.0);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void eggsHatchReturnsBabyKraken() {
        Nymph baby = Nymph.giveBirth();
        assertNotNull(baby);
        assertEquals(Age.BABY, baby.getAge());
    }

    @Test
    void eggsHatchReturnsBabyWithRandomGender() {
        Set<Gender> genders = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            genders.add(Nymph.giveBirth().getSexe());
        }
        assertTrue(genders.contains(Gender.MALE));
        assertTrue(genders.contains(Gender.FEMALE));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomWeight() {
        Set<Double> weights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            weights.add(Nymph.giveBirth().getWeight());
        }
        assertTrue(weights.stream().anyMatch(weight -> weight > 1 && weight < 4));
    }

    @Test
    void eggsHatchReturnsBabyWithRandomHeight() {
        Set<Double> heights = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            heights.add(Nymph.giveBirth().getHeight());
        }
        assertTrue(heights.stream().anyMatch(height -> height > 0.7 && height < 1.5));
    }
}