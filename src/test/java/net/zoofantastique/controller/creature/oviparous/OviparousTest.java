package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.viviparous.Viviparous;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OviparousTest {

    @Test
    void testToString() {
        Oviparous v = new Oviparous("Viviparous", Gender.MALE, 1.0, 0.5, "Test");
        // TODO
    }
}