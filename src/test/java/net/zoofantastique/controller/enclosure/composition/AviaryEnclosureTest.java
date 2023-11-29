package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.enclosure.behavior.Cleanness;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Phoenix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AviaryEnclosureTest {
    private AviaryEnclosure<Phoenix> aviaryEnclosure;
    private Phoenix phoenix;

    @BeforeEach
    void setUp() {
        aviaryEnclosure = new AviaryEnclosure<>("Test Aviary", 100.0, 50.0, 10);
        phoenix = new Phoenix("Test Phoenix", Gender.MALE, 100.0, 2.0);
    }

    @Test
    void whenAddCreatureThenAddsSuccessfully() {
        aviaryEnclosure.addCreature(phoenix);
        assertEquals(aviaryEnclosure.getListCreature().get(0), phoenix);
    }

    @Test
    void whenAddCreatureThenIncrementeNbCreature() {
        aviaryEnclosure.addCreature(phoenix);
        assertEquals(1, aviaryEnclosure.getNbCreature());
    }

    @Test
    void whenAddCreatureExceedsMaxCapacityThenDoesNotAdd() {
        for (int i = 0; i < 11; i++) {
            aviaryEnclosure.addCreature(phoenix);
        }
        assertEquals(10, aviaryEnclosure.getNbCreature());
    }

    @Test
    void whenMaintenanceOnEmptyAviaryThenNoMaintenancePerformed() {
        aviaryEnclosure.maintenance();
        assertEquals(50.0, aviaryEnclosure.getRoofHeight());
    }

    @Test
    void whenMaintenanceOnNonEmptyAviaryThenPerformsMaintenance() {
        aviaryEnclosure.addCreature(phoenix);
        aviaryEnclosure.maintenance();
        assertEquals(Cleanness.GOOD, aviaryEnclosure.getCleanness());
    }

    @Test
    void getHeightReturnsCorrectHeight() {
        assertEquals(50.0, aviaryEnclosure.getRoofHeight());
    }

    @Test
    void setHeightChangesHeightCorrectly() {
        aviaryEnclosure.setRoofHeight(60.0);
        assertEquals(60.0, aviaryEnclosure.getRoofHeight());
    }

    @Test
    void toStringIndentationIsAsIntended() {
        String expectedString = """
        <-/ AviaryEnclosure \\->
        -------------------------
        Nom: Test Aviary
        Superficie: 100.0m²
        Max creatures: 10
        Nb creatures: 0 / 10
        Propreté: Correct
        Hauteur: 50.0m
        """;
        assertEquals(expectedString, aviaryEnclosure.toString());
    }

    @Test
    void toStringHasTheCreatureListToStringAtEndOfIsToString() {
        String s = """
                <-/ AviaryEnclosure \\->
                -------------------------
                Nom: Test Aviary
                Superficie: 100.0m²
                Max creatures: 10
                Nb creatures: 1 / 10
                Propreté: Correct
                Hauteur: 50.0m

                Listes des créatures:

                <-/ Phoenix \\->
                --------------
                Nom: Test Phoenix
                Sexe: Male
                Age: Bébé
                Cri: coua coua
                Poids: 100.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s
                """;
        aviaryEnclosure.addCreature(phoenix);
        assertEquals(s, aviaryEnclosure.toString());
    }
}