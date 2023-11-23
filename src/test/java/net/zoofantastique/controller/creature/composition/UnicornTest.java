package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.viviparous.Unicorn;
import org.junit.jupiter.api.Test;

class UnicornTest {

    @Test
    void canTheUnicornRun() {
        Unicorn c = new Unicorn("Unicorn", Gender.MALE, 10000, 20);
        c.run();
    }
}