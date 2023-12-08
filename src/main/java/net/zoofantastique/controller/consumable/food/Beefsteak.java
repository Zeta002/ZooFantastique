package net.zoofantastique.controller.consumable.food;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.consumable.behavior.FoodType;

/**
 * Classe Beefsteak, hérite de la classe Food.
 * Cette classe représente un morceau de steak.
 */
public class Beefsteak extends Food {
    public Beefsteak() {
        super("Steak", 4, FoodType.TERRESTRIAL);
        String desc = """
                Un morceau généreux de steak fantastique, prélevé\s
                avec soin des bêtes extraordinaires qui errent dans les vastes\s
                prairies magiques. Le Beefsteak est réputé pour sa tendreté\s
                incomparable et sa saveur riche. C'est une délicieuse source\s
                de protéines pour les créatures qui courent avec agilité, offrant\s
                une expérience culinaire robuste et nourrissante.""";
        super.setDesc(desc);
    }
}
