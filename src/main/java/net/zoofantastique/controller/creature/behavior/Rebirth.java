package net.zoofantastique.controller.creature.behavior;

public interface Rebirth {
    default void rebirth() {
        System.out.println("La créature renait.");
    }
}
