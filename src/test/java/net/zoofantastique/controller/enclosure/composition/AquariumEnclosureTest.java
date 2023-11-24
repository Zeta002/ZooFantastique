package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.enclosure.behavior.Salinity;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AquariumEnclosureTest {
    private AquariumEnclosure<Dragon> aquariumEnclosure;
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        aquariumEnclosure = new AquariumEnclosure<>("Test Aquarium", 100.0, 50.0, 10);
        dragon = new Dragon("Test Dragon", Gender.MALE, 100.0, 2.0);
    }

    @Test
    void whenAddSwimmerCreatureThenAddsSuccessfully() {
        aquariumEnclosure.addCreature(dragon);
        assertEquals(aquariumEnclosure.getListCreature().get(0), dragon);
    }

    @Test
    void whenAddSwimmerCreatureThenIncrementeNbCreature() {
        aquariumEnclosure.addCreature(dragon);
        assertEquals(1, aquariumEnclosure.getNbCreature());
    }

    @Test
    void whenAddCreatureExceedsMaxCapacityThenDoesNotAdd() {
        for (int i = 0; i < 11; i++) {
            aquariumEnclosure.addCreature(dragon);
        }
        assertEquals(10, aquariumEnclosure.getNbCreature());
    }

    @Test
    void whenMaintenanceOnEmptyAquariumThenNoMaintenancePerformed() {
        aquariumEnclosure.maintenance();
        assertEquals(Salinity.BRACKISHWATER, aquariumEnclosure.getBasinSalinity());
    }

    @Test
    void whenMaintenanceOnNonEmptyAquariumThenPerformsMaintenance() {
        aquariumEnclosure.addCreature(dragon);
        aquariumEnclosure.maintenance();
        assertNotEquals(Salinity.BRACKISHWATER, aquariumEnclosure.getBasinSalinity());
    }

    @Test
    void getBasinDepthReturnsCorrectDepth() {
        assertEquals(50.0, aquariumEnclosure.getBasinDepth());
    }

    @Test
    void setBasinDepthChangesDepthCorrectly() {
        aquariumEnclosure.setBasinDepth(60.0);
        assertEquals(60.0, aquariumEnclosure.getBasinDepth());
    }

    @Test
    void getBasinSalinityReturnsCorrectSalinity() {
        assertEquals(Salinity.BRACKISHWATER, aquariumEnclosure.getBasinSalinity());
    }

    @Test
    void setBasinSalinityChangesSalinityCorrectly() {
        aquariumEnclosure.setBasinSalinity(Salinity.SALTWATER);
        assertEquals(Salinity.SALTWATER, aquariumEnclosure.getBasinSalinity());
    }

    @Test
    void toStringIndentationIsAsIntended() {
        String expectedString = """
        <-/ AquariumEnclosure \\->
        -------------------------
        Nom: Test Aquarium
        Superficie: 100.0m²
        Max creatures: 10
        Nb creatures: 0 / 10
        Propreté: Correct
        Profondeur: 50.0m
        Salinité: eau saumâtre
        """;
        assertEquals(expectedString, aquariumEnclosure.toString());
    }

    @Test
    void toStringHasTheCreatureListToStringAtEndOfIsToString() {
        String expectedString = """
                <-/ AquariumEnclosure \\->
                -------------------------
                Nom: Test Aquarium
                Superficie: 100.0m²
                Max creatures: 10
                Nb creatures: 1 / 10
                Propreté: Correct
                Profondeur: 50.0m
                Salinité: eau saumâtre
                
                Listes des créatures:
                        
                <-/ Dragon \\->
                --------------
                Nom: Test Dragon
                Sexe: Male
                Age: Bébé
                Cri: graou
                Poids: 100.0kg
                Taille: 2.0m
                Dort: Non
                Malade: Non
                Faim: Répu
                Durée d'incubation: 0s
                """;
        aquariumEnclosure.addCreature(dragon);
        assertEquals(expectedString, aquariumEnclosure.toString());
    }
}