package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

class PhoenixTest {

    @Test
    void fly() {
        Phoenix c = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
        c.fly();
    }
}