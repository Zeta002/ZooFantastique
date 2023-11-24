package net.zoofantastique.controller.enclosure;

import net.zoofantastique.controller.enclosure.behavior.Salinity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalinityTest {
    @Test
    void nextSalinityReturnsNextSalinity() {
        assertEquals(Salinity.BRACKISHWATER, Salinity.SALTWATER.increment());
    }

    @Test
    void nextSalinityReturnsSameSalinityIfAlreadyAtMax() {
        assertEquals(Salinity.FRESHWATER, Salinity.FRESHWATER.increment());
    }

    @Test
    void previousSalinityReturnsPreviousSalinity() {
        assertEquals(Salinity.BRACKISHWATER, Salinity.FRESHWATER.decrement());
    }

    @Test
    void previousSalinityReturnsSameSalinityIfAlreadyAtMin() {
        assertEquals(Salinity.SALTWATER, Salinity.SALTWATER.decrement());
    }

    @Test
    void getValueReturnsCorrectValueSALTWATER() {
        assertEquals("eau salée", Salinity.SALTWATER.getValue());
    }

    @Test
    void getValueReturnsCorrectValueBRACKISHWATER() {
        assertEquals("eau saumâtre", Salinity.BRACKISHWATER.getValue());
    }

    @Test
    void getValueReturnsCorrectValueFRESHWATER() {
        assertEquals("eau douce", Salinity.FRESHWATER.getValue());
    }
}