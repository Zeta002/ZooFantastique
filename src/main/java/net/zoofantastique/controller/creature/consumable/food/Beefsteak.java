package net.zoofantastique.controller.creature.consumable.food;

import net.zoofantastique.controller.creature.consumable.composition.Food;
import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public class Beefsteak extends Food {
    public Beefsteak() {
        super.setName("Steak");
        super.setValue(4);
        StringBuilder desc = new StringBuilder();
        desc.append("Un morceau généreux de steak fantastique, prélevé")
                .append(" \navec soin des bêtes extraordinaires qui errent dans les vastes")
                .append(" \nprairies magiques. Le Beefsteak est réputé pour sa tendreté")
                .append(" \nincomparable et sa saveur riche. C'est une délicieuse source")
                .append(" \nde protéines pour les créatures qui courent avec agilité, offrant")
                .append(" \nune expérience culinaire robuste et nourrissante.");
        super.setDesc(desc.toString());
        super.setFoodType(FoodType.TERRESTRIAL);
    }
}
