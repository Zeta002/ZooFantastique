package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class OceanDelight extends Food {
    public OceanDelight() {
        super.setName("Délice océanien");
        super.setValue(4);
        StringBuilder desc = new StringBuilder();
        desc.append("Un festin délicieux composé de divers délices marins, l'Ocean Delight")
                .append(" est conçu pour émerveiller les palais des créatures qui nagent dans ")
                .append("les océans fantastiques. Il offre une expérience culinaire digne des fonds")
                .append(" marins enchanteurs.");
        super.setDesc(desc.toString());
        super.setFoodType(FoodType.MARINE);
    }
}
