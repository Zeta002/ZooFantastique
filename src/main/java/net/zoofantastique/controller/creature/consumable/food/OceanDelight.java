package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class OceanDelight extends Food {
    public OceanDelight() {
        super.setName("Délice océanien");
        super.setValue(4);
        super.setDesc("Un festin délicieux composé de divers délices marins, l'Ocean Delight" +
                " est conçu pour émerveiller les palais des créatures qui nagent dans " +
                "les océans fantastiques. Il offre une expérience culinaire digne des fonds" +
                " marins enchanteurs.");
        super.setFoodType(FoodType.MARINE);
    }
}
