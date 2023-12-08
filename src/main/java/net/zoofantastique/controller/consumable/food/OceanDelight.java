package net.zoofantastique.controller.consumable.food;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.consumable.behavior.FoodType;

/**
 * Classe OceanDelight, hérite de la classe Food.
 * Cette classe représente un festin délicieux composé de divers délices marins.
 */
public class OceanDelight extends Food {
    public OceanDelight() {
        super("Délice océanien", 4, FoodType.MARINE);
        String desc = """
                Un festin délicieux composé de divers délices marins, l'Ocean Delight\s
                est conçu pour émerveiller les palais des créatures qui nagent dans\s
                les océans fantastiques. Il offre une expérience culinaire digne des fonds\s
                marins enchanteurs.""";
        super.setDesc(desc);
    }
}
