package net.zoofantastique.controller.enclosure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CleannessTest {

    private Cleanness cleanness;

    @BeforeEach
    void setUp() {
        cleanness = Cleanness.GOOD;
    }

    @Test
    void deteriorateShouldDecreaseCleanness() {
        assertEquals(Cleanness.CORRECT, cleanness.deteriorate());
    }

    @Test
    void deteriorateShouldNotDecreaseCleannessWhenBad() {
        cleanness = Cleanness.BAD;
        assertEquals(Cleanness.BAD, cleanness.deteriorate());
    }

    @Test
    void cleanShouldIncreaseCleanness() {
        cleanness = Cleanness.BAD;
        assertEquals(Cleanness.CORRECT, cleanness.clean());
    }

    @Test
    void cleanShouldNotIncreaseCleannessWhenGood() {
        assertEquals(Cleanness.GOOD, cleanness.clean());
    }

    @Test
    void getValue() {
    }

    @Test
    void clean() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}