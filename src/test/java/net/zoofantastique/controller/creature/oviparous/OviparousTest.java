package net.zoofantastique.controller.creature.oviparous;

import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.composition.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OviparousTest {

    @Test
    void testToString() {
        Oviparous v = new Dragon("Dragon", Gender.MALE, 1000.0, 2.0);
        assertEquals("""
                <-/ Dragon \\->
                --------------
                Nom: Dragon
                Sexe: Male
                Age: Bébé
                Cri: graou
                Poids: 1000.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s""", v.toString());
    }
}