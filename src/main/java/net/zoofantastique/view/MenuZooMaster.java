package net.zoofantastique.view;

import java.util.Scanner;

import static net.zoofantastique.view.ConsoleTricks.boldText;
import static net.zoofantastique.view.ConsoleTricks.waitEnter;

public class MenuZooMaster {

    public static void displayMainMenu(Game game) {
        System.out.println("Bienvenue dans le " + boldText(game.getZoo().getZooName()) + ", que voulez-vous faire?");
        System.out.println("1 - Afficher un enclos");
        System.out.println("2 - Faire la maintenance d'un enclos");
        System.out.println("3 - Nourrir une créature");
        System.out.println("4 - Transférer une créature");
        System.out.println("5 - Ajouter un enclos");
        System.out.println("6 - Ajouter une créature");
        System.out.println("7 - Quitter le jeu");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                // TODO : afficher un enclos
                showEnclosure(game);
                break;
            case "2":
                // TODO : faire la maintenance d'un enclos
                break;
            case "3":
                // TODO : nourrir une créature
                break;
            case "4":
                // TODO : transférer une créature
                break;
            case "5":
                // TODO : ajouter un enclos
                break;
            case "6":
                // TODO : ajouter une créature
                break;
            case "7":
                System.out.println("Merci d'avoir joué à Idle Zoo Fantastique Tycoon!");
                System.out.println("À bientôt!");
                System.out.println("D'ailleurs, vos données ont bien " + boldText("pas") + " été sauvegardées.");
                waitEnter(true);
                System.exit(0);
                break;
            default:
                System.out.println("L'option que vous avez choisi n'existe pas, rentrer un chiffre entre 1 et .");
                ConsoleTricks.waitEnter(true);
                break;
        }
    }

    public static void showEnclosure(Game game) {
        System.out.println("Voici la liste des enclos de " + boldText(game.getZoo().getZooName()) + ":");
        for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
            System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(i).getName()));
        }
        System.out.println("Quel enclos voulez-vous afficher?");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice < game.getZoo().getEnclosures().size()) {
            System.out.println(game.getZoo().getEnclosures().get(choice).showCreatures());
            ConsoleTricks.waitEnter("retourner au menu",true);
        } else {
            System.out.println("L'enclos que vous avez choisi n'existe pas, veuillez choisir un enclos existant.");
            ConsoleTricks.waitEnter(true);
            showEnclosure(game);
        }
    }
}
