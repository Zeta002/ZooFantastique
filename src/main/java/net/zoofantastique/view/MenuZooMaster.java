package net.zoofantastique.view;

import net.zoofantastique.controller.entity.zoomaster.ZooMaster;

import java.util.Scanner;

public class MenuZooMaster implements ConsoleTricks {
    private ZooMaster zooMaster;

    public void displayMenu(ZooMaster zooMaster) {
        System.out.println("Bienvenue dans le menu du ZooMaster " + "\033[1m" + zooMaster.getName() + "\033[0m" + ", que voulez-vous faire?");
        System.out.println("1 - Afficher un enclos");
        System.out.println("2 - Faire la maintenance d'un enclos");
        System.out.println("3 - Nourrir une créature");
        System.out.println("4 - Transférer une créature");
        System.out.println("5 - Quitter");
    }

    public void menuOptions() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option == 1) {
            // TODO : afficher un enclos
        } else if (option == 2) {
            // TODO : faire la maintenance d'un enclos
        } else if (option == 3) {
            // TODO : nourrir une créature
        } else if (option == 4) {
            // TODO : transférer une créature
        } else if (option == 5) {
            clearConsole();
            // TODO : afficher le menu précédent (MenuZooFantastique)
        } else {
            System.out.println("L'option que vous avez choisi n'existe pas, rentrer un chiffre entre 1 et 5.");
            clearConsole();
            menuOptions();
        }
    }
}
