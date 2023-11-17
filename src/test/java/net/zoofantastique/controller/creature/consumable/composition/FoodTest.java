package net.zoofantastique.controller.creature.consumable.composition;

import net.zoofantastique.controller.creature.consumable.behavior.FoodType;
import net.zoofantastique.controller.creature.consumable.food.Beefsteak;
import net.zoofantastique.controller.creature.consumable.food.OceanDelight;
import net.zoofantastique.controller.creature.consumable.food.SkySeeds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {
    private Food food;

    @BeforeEach
    void setUp() {
        // Vous pouvez choisir le type de Food que vous souhaitez tester ici
        food = new Beefsteak();
    }

    @Test
    void getName() {
        assertEquals("Steak", food.getName());
    }

    @Test
    void setName() {
        food = new OceanDelight();
        food.setName("Test");
        assertEquals("Test", food.getName());
    }

    @Test
    void getValue() {
        food = new SkySeeds();
        assertEquals(4, food.getValue());
    }

    @Test
    void setValue() {
        food = new Beefsteak();
        food.setValue(5);
        assertEquals(5, food.getValue());
    }

    @Test
    void getFoodType() {
        food = new OceanDelight();
        assertEquals(FoodType.MARINE, food.getFoodType());
    }

    @Test
    void getFoodTypeValue() {
        food = new SkySeeds();
        assertEquals("Aérien", food.getFoodTypeValue());
    }

    @Test
    void setFoodType() {
        food = new Beefsteak();
        food.setFoodType(FoodType.AERIAL);
        assertEquals(FoodType.AERIAL, food.getFoodType());
    }

    @Test
    void getDesc() {
        food = new OceanDelight();
        assertEquals(new StringBuilder()
                .append("Un festin délicieux composé de divers délices marins, l'Ocean Delight")
                .append(" est conçu pour émerveiller les palais des créatures qui nagent dans")
                .append(" les océans fantastiques. Il offre une expérience culinaire digne des fonds")
                .append(" marins enchanteurs.").toString(), food.getDesc());
    }

    @Test
    void setDesc() {
        food = new SkySeeds();
        food.setDesc("Test");
        assertEquals("Test", food.getDesc());
    }

    @Test
    void testToString() {
        food = new Beefsteak();
        assertEquals("""
                <-/ Steak \\->
                --------------
                Valeur: 3
                Type: Terrestre
                Description: Un morceau généreux de steak fantastique, prélevé avec soin des bêtes extraordinaires qui errent dans les vastes prairies magiques. Le Beefsteak est réputé pour sa tendreté incomparable et sa saveur riche. C'est une délicieuse source de protéines pour les créatures qui courent avec agilité, offrant une expérience culinaire robuste et nourrissante.
                """, food.toString());
    }
}
