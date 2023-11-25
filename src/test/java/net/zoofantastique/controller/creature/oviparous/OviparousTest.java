package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Oviparous;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OviparousTest {

    @Test
    void testToString() {
        Oviparous v = new Dragon("Charles", Gender.MALE, 1000.0, 2.0);
        assertEquals("""
                <-/ Dragon \\->
                --------------
                Nom: Charles
                Sexe: Male
                Age: Bébé
                Cri: graou
                Poids: 1000.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s
                """, v.toString());
    }
}