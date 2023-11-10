package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class SkySeeds extends Food {
    public SkySeeds() {
        super.setName("Graine céleste");
        super.setValue(4);
        super.setDesc("Des graines magiques récoltées dans les cieux enchantés," +
                " ces Sky Seeds sont riches en éléments aériens essentiels pour les" +
                " créatures qui peuvent voler. Elles confèrent une énergie légère et" +
                " aident à maintenir la vitalité dans les cieux.");
        super.setFoodType(FoodType.AERIAL);
    }
}
