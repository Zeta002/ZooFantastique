package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DragonTest {
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        dragon = new Dragon("Jhon", Gender.MALE, 10000, 20);
    }

    @Test
    void canTheDragonCanFly() {
        dragon.fly();
    }

    @Test
    void canTheDragonCanRun() {
        dragon.run();
    }

    @Test
    void canTheDragonCanSwim() {
        dragon.swim();
    }

    @Test
    void didAgingRebirthWhenDead() {
        dragon.aging();
        dragon.aging();
        dragon.aging();
        dragon.aging();
        assertEquals(Age.BABY, dragon.getAge());
    }

    @Test
    void didSetAgeRebirthWhenDead() {
        dragon.setAge(Age.DEAD);
        assertEquals(Age.BABY, dragon.getAge());
    }

    @Test
    void didRebirthChangeNothingWhenItSupposeTo() {
        dragon.rebirth();
        assertEquals(Age.BABY, dragon.getAge());
    }
}
