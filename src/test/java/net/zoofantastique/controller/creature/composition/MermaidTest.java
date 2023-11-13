package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Gender;
import org.junit.jupiter.api.Test;

class MermaidTest {

    @Test
    void canTheMermaidSwim() {
        Mermaid c = new Mermaid("Mermaid", Gender.MALE, 10000, 20);
        c.swim();
    }
}