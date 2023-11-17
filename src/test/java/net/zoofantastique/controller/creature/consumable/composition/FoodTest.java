package net.zoofantastique.controller.creature.consumable.composition;

import net.zoofantastique.controller.creature.consumable.behavior.FoodType;
import net.zoofantastique.controller.creature.consumable.food.Beefsteak;
import net.zoofantastique.controller.creature.consumable.food.OceanDelight;
import net.zoofantastique.controller.creature.consumable.food.SkySeeds;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {

    @Test
    void getName() {
        Food f = new Beefsteak();
        assertEquals("Steak", f.getName());
    }

    @Test
    void setName() {
        Food f = new OceanDelight();
        f.setName("Test");
        assertEquals("Test", f.getName());
    }

    @Test
    void getValue() {
        Food f = new SkySeeds();
        assertEquals(4, f.getValue());
    }

    @Test
    void setValue() {
        Food f = new Beefsteak();
        f.setValue(5);
        assertEquals(5, f.getValue());
    }

    @Test
    void getFoodType() {
        Food f = new OceanDelight();
        assertEquals(FoodType.MARINE, f.getFoodType());
    }

    @Test
    void getFoodTypeValue() {
        Food f = new SkySeeds();
        assertEquals("Aérien", f.getFoodTypeValue());
    }

    @Test
    void setFoodType() {
        Food f = new Beefsteak();
        f.setFoodType(FoodType.AERIAL);
        assertEquals(FoodType.AERIAL, f.getFoodType());
    }

    @Test
    void getDesc() {
        Food f = new OceanDelight();
        assertEquals("Un festin délicieux composé de divers délices marins, l'Ocean Delight" +
                              " est conçu pour émerveiller les palais des créatures qui nagent dans" +
                              " les océans fantastiques. Il offre une expérience culinaire digne des fonds" +
                              " marins enchanteurs.", f.getDesc());
    }

    @Test
    void setDesc() {
        Food f = new SkySeeds();
        f.setDesc("Test");
        assertEquals("Test", f.getDesc());
    }

    @Test
    void testToString() {
        Food f = new Beefsteak();
        assertEquals("""
                <-/ Beefsteak \\->
                --------------
                Nom: Steak
                Valeur: 3
                Type: Terrestre
                Description: Un morceau généreux de steak fantastique, prélevé avec soin des bêtes extraordinaires qui errent dans les vastes prairies magiques. Le Beefsteak est réputé pour sa tendreté incomparable et sa saveur riche. C'est une délicieuse source de protéines pour les créatures qui courent avec agilité, offrant une expérience culinaire robuste et nourrissante.""", f.toString());
    }
}