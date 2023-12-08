package net.zoofantastique.view;

import java.util.Scanner;

/**
 * Interface ConsoleTricks qui représente une interface utilitaire pour la console.
 * Cette interface contient des méthodes utilitaires pour la console.
 */
public interface ConsoleTricks {

    Scanner scanner = new Scanner(System.in);

    // Méthodes

    // TODO : doc
    static void clearConsole() {
        System.out.println("\n".repeat(20));
    }

    // TODO : doc
    static void waitEnter(Boolean clear) {
        do {
            System.out.println("Appuyer sur entrée pour continuer...");
        } while (!scanner.hasNextLine());
        scanner.nextLine();
        if (clear)
            clearConsole();
    }

    // TODO : doc
    static void waitEnter(String message, Boolean clear) {
        do {
            System.out.println("Appuyer sur entrée pour " + message + "...");
        } while (!scanner.hasNextLine());
        scanner.nextLine();
        if (clear)
            clearConsole();
    }

    // TODO : doc
    static String scan() {
        return scanner.nextLine();
    }

    // TODO : doc
    static String boldText(String text) {
        return "\033[1m" + text + "\033[0m";
    }
}
