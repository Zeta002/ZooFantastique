package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.oviparous.Phoenix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoenixTest {
    private Phoenix phoenix;

    @BeforeEach
    void setUp() {
        phoenix = new Phoenix("Phoenix", Gender.MALE, 10000, 20);
    }

    @Test
    void canThePhoenixFly() {
        phoenix.fly();
    }

    @Test
    void didAgingRebirthWhenDead() {
        phoenix.aging();
        phoenix.aging();
        phoenix.aging();
        phoenix.aging();
        assertEquals(Age.BABY, phoenix.getAge());
    }

    @Test
    void didSetAgeRebirthWhenDead() {
        phoenix.setAge(Age.DEAD);
        assertEquals(Age.BABY, phoenix.getAge());
    }

    @Test
    void didRebirthChangeNothingWhenItSupposeTo() {
        phoenix.rebirth();
        assertEquals(Age.BABY, phoenix.getAge());
    }
}
