package net.zoofantastique.controller.consumable.food;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.consumable.behavior.FoodType;

/**
 * Classe SkySeeds, hérite de la classe Food.
 * Cette classe représente des graines magiques récoltées dans les cieux enchantés.
 */
public class SkySeeds extends Food {
    public SkySeeds() {
        super("Graine céleste", 4, FoodType.AERIAL);
        String desc = """
                Des graines magiques récoltées dans les cieux enchantés,\s
                ces Sky Seeds sont riches en éléments aériens essentiels pour les\s
                créatures qui peuvent voler. Elles confèrent une énergie légère et\s
                aident à maintenir la vitalité dans les cieux.""";
        super.setDesc(desc);
    }
}
