package net.zoofantastique.controller.enclosure.behavior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CleannessTest {
    @Test
    void cleanReturnsNextCleanness() {
        assertEquals(Cleanness.CORRECT, Cleanness.BAD.clean());
    }

    @Test
    void cleanIsChangingValueCorrectly() {
        assertEquals(Cleanness.CORRECT.getValue(), Cleanness.BAD.clean().getValue());
    }

    @Test
    void deteriorateReturnsPreviousCleanness() {
        assertEquals(Cleanness.CORRECT, Cleanness.GOOD.deteriorate());
    }

    @Test
    void deteriorateIsChangingValueCorrectly() {
        assertEquals(Cleanness.CORRECT.getValue(), Cleanness.GOOD.deteriorate().getValue());
    }

    @Test
    void cleanReturnsSameCleannessIfAlreadyAtMax() {
        assertEquals(Cleanness.GOOD, Cleanness.GOOD.clean());
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