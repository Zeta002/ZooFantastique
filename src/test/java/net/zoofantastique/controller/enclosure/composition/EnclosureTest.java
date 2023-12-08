package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.consumable.food.Beefsteak;
import net.zoofantastique.controller.enclosure.behavior.Cleanness;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Hunger;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnclosureTest {
    private Enclosure<Dragon> enclosure;
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        enclosure = new Enclosure<>("Test Enclosure", 100.0, 10);
        dragon = new Dragon("Test Dragon", Gender.FEMALE);
        dragon.setHeight(2.0);
        dragon.setWeight(100.0);
    }

    @Test
    void whenInstanciantedCleanessIsCorrect() {
        assertEquals(Cleanness.CORRECT, enclosure.getCleanness());
    }

    @Test
    void whenAddCreatureThenAddsSuccessfully() {
        enclosure.addCreature(dragon);
        assertEquals(enclosure.getListCreature().get(0), dragon);
    }

    @Test
    void whenAddCreatureThenIncrementeNbCreature() {
        enclosure.addCreature(dragon);
        assertEquals(1, enclosure.getNbCreature());
    }

    @Test
    void whenAddCreatureExceedsMaxCapacityThenDoesNotAdd() {
        for (int i = 0; i < 11; i++) {
            enclosure.addCreature(dragon);
        }
        assertEquals(10, enclosure.getNbCreature());
    }

    @Test
    void whenRemoveCreatureThenDecrementsNbCreature() {
        enclosure.addCreature(dragon);
        enclosure.removeCreature(dragon);
        assertEquals(0, enclosure.getNbCreature());
    }

    @Test
    void whenRemoveCreatureNotInEnclosureThenDoesNotDecrementNbCreature() {
        enclosure.removeCreature(dragon);
        assertEquals(0, enclosure.getNbCreature());
    }

    @Test
    void whenFeedCreatureThenCreatureEats() {
        enclosure.addCreature(dragon);
        dragon.setHunger(5);
        enclosure.feedCreature(new Beefsteak(), dragon);
        assertEquals(Hunger.SATISFIED.getState(), dragon.getHungerState());
    }

    @Test
    void whenMaintenanceOnEmptyEnclosureThenNoMaintenancePerformed() {
        enclosure.maintenance();
        assertEquals(Cleanness.CORRECT, enclosure.getCleanness());
    }

    @Test
    void whenMaintenanceOnNonEmptyEnclosureThenPerformsMaintenance() {
        enclosure.addCreature(dragon);
        enclosure.maintenance();
        assertNotEquals(Cleanness.CORRECT, enclosure.getCleanness());
    }

    @Test
    void getSurfaceReturnsCorrectSurface() {
        assertEquals(100.0, enclosure.getSurface());
    }

    @Test
    void setSurfaceChangesSurfaceCorrectly() {
        enclosure.setSurface(60.0);
        assertEquals(60.0, enclosure.getSurface());
    }

    @Test
    void getMaxReturnsCorrectMax() {
        assertEquals(10, enclosure.getMax());
    }

    @Test
    void setMaxChangesMaxCorrectly() {
        enclosure.setMax(20);
        assertEquals(20, enclosure.getMax());
    }

    @Test
    void toStringIndentationIsAsIntended() {
        String expectedString = """
    <-/ Enclosure \\->
    -------------------------
    Nom: Test Enclosure
    Superficie: 100.0m²
    Max creatures: 10
    Nb creatures: 0 / 10
    Propreté: Correct
    """;
        assertEquals(expectedString, enclosure.toString());
    }

    @Test
    void toStringHasTheCreatureListToStringAtEndOfIsToString() {
        String expectedString = """
            <-/ Enclosure \\->
            -------------------------
            Nom: Test Enclosure
            Superficie: 100.0m²
            Max creatures: 10
            Nb creatures: 1 / 10
            Propreté: Correct

            Listes des créatures:

            <-/ Dragon \\->
            --------------
            Nom: Test Dragon
            Sexe: Femelle
            Age: Bébé
            Cri: graou
            Poids: 100.0kg
            Taille: 2.0m
            Dort: Non
            Malade: Non
            Faim: Répu
            Durée d'incubation: 30 jours
            """;
        enclosure.addCreature(dragon);
        assertEquals(expectedString, enclosure.toString());
    }
}