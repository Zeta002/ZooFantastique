package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

class KrakenTest {

    @Test
    void swim() {
        Kraken k = new Kraken("Kraken", Gender.MALE, 20000, 50);
        k.swim();
    }
}