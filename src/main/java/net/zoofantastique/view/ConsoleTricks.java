package net.zoofantastique.view;

public interface ConsoleTricks {
    default void clearConsole() {
        System.out.println("\n".repeat(20));
    }
}
