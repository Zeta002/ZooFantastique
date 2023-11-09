package net.zoofantastique.controller.creature.consumable;

public class Beefsteak implements Food {
    String name = "Steak";
    int value = 2;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
