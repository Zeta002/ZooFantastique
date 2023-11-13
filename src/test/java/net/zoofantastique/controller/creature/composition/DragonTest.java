package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DragonTest {
    @Test
    void canTheDragonCanFly() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.fly();
    }

    @Test
    void canTheDragonCanRun() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.run();
    }

    @Test
    void canTheDragonCanSwim() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.swim();
    }

    @Test
    void didAgingRebirthWhenDead() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.aging();
        c.aging();
        c.aging();
        c.aging();
        assertEquals(Age.BABY, c.getAge());
    }

    @Test
    void didSetAgeRebirthWhenDead() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.setAge(Age.DEAD);
        assertEquals(Age.BABY, c.getAge());
    }

    @Test
    void didRebirthChangeNothingWhenItSupposeTo() {
        Dragon c = new Dragon("Dragon", Gender.MALE, 10000, 20);
        c.rebirth();
        assertEquals(Age.BABY, c.getAge());
    }
}