package net.zoofantastique.controller.enclosure.behavior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CleannessTest {
    @Test
    void cleanReturnsNextCleanness() {
        assertEquals(Cleanness.CORRECT, Cleanness.BAD.clean());
    }

    @Test
    void cleanReturnsSameCleannessIfAlreadyAtMax() {
        assertEquals(Cleanness.GOOD, Cleanness.GOOD.clean());
    }

    @Test
    void deteriorateReturnsPreviousCleanness() {
        assertEquals(Cleanness.CORRECT, Cleanness.GOOD.deteriorate());
    }

    @Test
    void deteriorateReturnsSameCleannessIfAlreadyAtMin() {
        assertEquals(Cleanness.BAD, Cleanness.BAD.deteriorate());
    }

    @Test
    void getValueReturnsCorrectValueBAD() {
        assertEquals("Mauvais", Cleanness.BAD.getValue());
    }

    @Test
    void getValueReturnsCorrectValueCORRECT() {
        assertEquals("Correct", Cleanness.CORRECT.getValue());
    }

    @Test
    void getValueReturnsCorrectValueGOOD() {
        assertEquals("Bon", Cleanness.GOOD.getValue());
    }
}