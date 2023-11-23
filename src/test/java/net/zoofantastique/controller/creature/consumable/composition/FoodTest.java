package net.zoofantastique.controller.creature.consumable.composition;

import net.zoofantastique.controller.consumable.behavior.FoodType;
import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.consumable.food.Beefsteak;
import net.zoofantastique.controller.consumable.food.OceanDelight;
import net.zoofantastique.controller.consumable.food.SkySeeds;
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
                .append(" \nest conçu pour émerveiller les palais des créatures qui nagent dans")
                .append(" \nles océans fantastiques. Il offre une expérience culinaire digne des fonds")
                .append(" \nmarins enchanteurs.").toString(), food.getDesc());
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
                Valeur: 4
                Type: Terrestre
                Description: Un morceau généreux de steak fantastique, prélevé\s
                avec soin des bêtes extraordinaires qui errent dans les vastes\s
                prairies magiques. Le Beefsteak est réputé pour sa tendreté\s
                incomparable et sa saveur riche. C'est une délicieuse source\s
                de protéines pour les créatures qui courent avec agilité, offrant\s
                une expérience culinaire robuste et nourrissante.
                """, food.toString());
    }
}
