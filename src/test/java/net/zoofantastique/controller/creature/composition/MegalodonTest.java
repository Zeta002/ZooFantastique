package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

class MegalodonTest {

    @Test
    void canTheMegalodoncSwim() {
        Megalodon c = new Megalodon("Megalodon", Gender.MALE, 10000, 20);
        c.swim();
    }
}