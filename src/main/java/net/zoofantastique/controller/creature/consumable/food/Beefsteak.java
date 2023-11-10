package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class Beefsteak extends Food {
    public Beefsteak() {
        super.setName("Steak");
        super.setValue(3);
        super.setDesc("Un morceau généreux de steak fantastique, prélevé" +
                " avec soin des bêtes extraordinaires qui errent dans les vastes" +
                " prairies magiques. Le Beefsteak est réputé pour sa tendreté" +
                " incomparable et sa saveur riche. C'est une délicieuse source" +
                " de protéines pour les créatures qui courent avec agilité, offrant" +
                " une expérience culinaire robuste et nourrissante.");
        super.setFoodType(FoodType.TERRESTRIAL);
    }
}
