package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

class LycanthropeTest {

    @Test
    void run() {
        Lycanthrope k = new Lycanthrope("Lycanthrope", Gender.MALE, 20000, 50);
        k.run();
    }
}