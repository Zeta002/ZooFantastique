package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoenixTest {

    @Test
    void canThePhoenixFly() {
        Phoenix c = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
        c.fly();
    }

    @Test
    void didAgingRebirthWhenDead() {
        Phoenix c = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
        c.aging();
        c.aging();
        c.aging();
        c.aging();
        assertEquals(Age.BABY, c.getAge());
    }

    @Test
    void didSetAgeRebirthWhenDead() {
        Phoenix c = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
        c.setAge(Age.DEAD);
        assertEquals(Age.BABY, c.getAge());
    }

    @Test
    void didRebirthChangeNothingWhenItSupposeTo() {
        Phoenix c = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
        c.rebirth();
        assertEquals(Age.BABY, c.getAge());
    }
}