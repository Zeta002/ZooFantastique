package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Kraken;
import org.junit.jupiter.api.Test;

class KrakenTest {

    @Test
    void canTheKrakenSwim() {
        Kraken k = new Kraken("Kraken", Gender.MALE, 20000, 50);
        k.swim();
    }
}