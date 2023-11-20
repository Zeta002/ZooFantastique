package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class SkySeeds extends Food {
    public SkySeeds() {
        super.setName("Graine céleste");
        super.setValue(4);
        StringBuilder desc = new StringBuilder();
        desc.append("Des graines magiques récoltées dans les cieux enchantés,")
                .append(" \nces Sky Seeds sont riches en éléments aériens essentiels pour les")
                .append(" \ncréatures qui peuvent voler. Elles confèrent une énergie légère et")
                .append(" \naident à maintenir la vitalité dans les cieux.");
        super.setDesc(desc.toString());
        super.setFoodType(FoodType.AERIAL);
    }
}
