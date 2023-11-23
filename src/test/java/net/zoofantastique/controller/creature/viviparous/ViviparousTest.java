package net.zoofantastique.controller.creature.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Mermaid;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Viviparous;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViviparousTest {

    @Test
    void testToString() {
        Viviparous v = new Mermaid("Thalassa", Gender.MALE, 1000.0, 2.0);
        assertEquals("""
                <-/ Mermaid \\->
                --------------
                Nom: Thalassa
                Sexe: Male
                Age: Bébé
                Cri: *chant mélodieux*
                Poids: 1000.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s
                """, v.toString());
    }
}