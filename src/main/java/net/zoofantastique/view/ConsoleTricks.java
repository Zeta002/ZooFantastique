package net.zoofantastique.view;

import java.util.Scanner;

public interface ConsoleTricks {

    Scanner scanner = new Scanner(System.in);

    static void clearConsole() {
        System.out.println("\n".repeat(20));
    }

    static void waitEnter(Boolean clear) {
        do {
            System.out.println("Appuyer sur entrée pour continuer...");
        } while (!scanner.hasNextLine());
        scanner.nextLine();
        if (clear)
            clearConsole();
    }

    static void waitEnter(String message, Boolean clear) {
        do {
            System.out.println("Appuyer sur entrée pour " + message + "...");
        } while (!scanner.hasNextLine());
        scanner.nextLine();
        if (clear)
            clearConsole();
    }

    static String scan() {
        return scanner.nextLine();
    }

    static String boldText(String text) {
        return "\033[1m" + text + "\033[0m";
    }
}
