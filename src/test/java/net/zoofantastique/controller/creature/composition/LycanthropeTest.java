package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.viviparous.Lycanthrope;
import org.junit.jupiter.api.Test;

class LycanthropeTest {

    @Test
    void canTheLycanthropRun() {
        Lycanthrope k = new Lycanthrope("Lycanthrope", Gender.MALE, 20000, 50);
        k.run();
    }
}