package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

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
}