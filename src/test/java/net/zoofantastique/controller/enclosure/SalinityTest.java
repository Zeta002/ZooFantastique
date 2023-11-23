package net.zoofantastique.controller.enclosure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalinityTest {

    private Salinity salinity;

    @Test
    void getValueShouldReturnCorrectValueForFreshwater() {
        salinity = Salinity.FRESHWATER;
        assertEquals("eau douce", Salinity.FRESHWATER.getValue());
    }

    @Test
    void getValueShouldReturnCorrectValueForBrackishwater() {
        salinity = Salinity.BRACKISHWATER;
        assertEquals("eau saumâtre", Salinity.BRACKISHWATER.getValue());
    }

    @Test
    void getValueShouldReturnCorrectValueForSaltwater() {
        salinity = Salinity.SALTWATER;
        assertEquals("eau salée", Salinity.SALTWATER.getValue());
    }

    @Test
    void setValueShouldChangeValue() {
        Salinity salinity = Salinity.FRESHWATER;
        salinity.setValue("new value");
        assertEquals("new value", salinity.getValue());
    }

    @Test
    void valuesShouldReturnAllEnumValues() {
        Salinity[] expected = {Salinity.SALTWATER, Salinity.BRACKISHWATER, Salinity.FRESHWATER};
        assertArrayEquals(expected, Salinity.values());
    }

    @Test
    void valueOfShouldReturnCorrectEnum() {
        assertEquals(Salinity.SALTWATER, Salinity.valueOf("SALTWATER"));
        assertEquals(Salinity.BRACKISHWATER, Salinity.valueOf("BRACKISHWATER"));
        assertEquals(Salinity.FRESHWATER, Salinity.valueOf("FRESHWATER"));
    }

    @Test
    void valueOfShouldThrowExceptionForInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> Salinity.valueOf("INVALID"));
    }

    @Test
    void decreaseSalinityFromBrackishwater() {
        salinity = Salinity.BRACKISHWATER;
        salinity.decreaseSalinity();
        assertEquals(Salinity.FRESHWATER.getValue(), salinity.getValue());
    }

    @Test
    void decreaseSalinityFromSaltwater() {
        salinity = Salinity.SALTWATER;
        salinity.decreaseSalinity();
        assertEquals(Salinity.BRACKISHWATER.getValue(), salinity.getValue());
    }

    @Test
    void decreaseSalinityFromFreshwater() {
        salinity = Salinity.FRESHWATER;
        salinity.decreaseSalinity();
        assertEquals(Salinity.FRESHWATER.getValue(), salinity.getValue());
    }

    @Test
    void increaseSalinityFromFreshwater() {
        salinity = Salinity.FRESHWATER;
        salinity.inscreaseSalinity();
        assertEquals(Salinity.BRACKISHWATER.getValue(), salinity.getValue());
    }

    @Test
    void increaseSalinityFromBrackishwater() {
        salinity = Salinity.BRACKISHWATER;
        salinity.inscreaseSalinity();
        assertEquals(Salinity.SALTWATER.getValue(), salinity.getValue());
    }

    @Test
    void increaseSalinityFromSaltwater() {
        salinity = Salinity.SALTWATER;
        salinity.inscreaseSalinity();
        assertEquals(Salinity.SALTWATER.getValue(), salinity.getValue());
    }
}