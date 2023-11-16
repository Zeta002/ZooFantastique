package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViviparousTest {

    @Test
    void testToString() {
        Viviparous v = new Viviparous("Viviparous", Gender.MALE, 1.0, 0.5, "Test");
        // TODO
    }
}