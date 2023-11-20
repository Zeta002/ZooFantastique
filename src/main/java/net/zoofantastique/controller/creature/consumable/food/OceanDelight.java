package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class OceanDelight extends Food {
    public OceanDelight() {
        super.setName("Délice océanien");
        super.setValue(4);
        StringBuilder desc = new StringBuilder();
        desc.append("Un festin délicieux composé de divers délices marins, l'Ocean Delight")
                .append(" \nest conçu pour émerveiller les palais des créatures qui nagent dans")
                .append(" \nles océans fantastiques. Il offre une expérience culinaire digne des fonds")
                .append(" \nmarins enchanteurs.");
        super.setDesc(desc.toString());
        super.setFoodType(FoodType.MARINE);
    }
}
