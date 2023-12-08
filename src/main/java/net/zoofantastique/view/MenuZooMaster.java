package net.zoofantastique.view;

import net.zoofantastique.controller.consumable.food.Beefsteak;
import net.zoofantastique.controller.enclosure.composition.AquariumEnclosure;
import net.zoofantastique.controller.enclosure.composition.AviaryEnclosure;
import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.oviparous.*;
import net.zoofantastique.controller.entity.creature.composition.viviparous.*;
import net.zoofantastique.utils.Utils;

import java.util.Scanner;

import static net.zoofantastique.view.ConsoleTricks.*;

/**
 * Classe MenuZooMaster qui représente le menu du jeu.
 * Cette classe contient des méthodes pour afficher le menu du jeu.
 */
public class MenuZooMaster {
    // Méthodes

    // TODO : doc
    public static void displayMainMenu(Game game) {
        System.out.println("Bienvenue dans le " + boldText(game.getZoo().getZooName()) + ", que voulez-vous faire?");
        System.out.println("1 - Afficher un enclos");
        System.out.println("2 - Faire la maintenance d'un enclos");
        System.out.println("3 - Nourrir une créature");
        System.out.println("4 - soigner une créature");
        System.out.println("5 - Transférer une créature");
        System.out.println("6 - Ajouter un enclos");
        System.out.println("7 - Ajouter une créature");
        System.out.println("8 - Quitter le jeu");

        String option = scan();
        switch (option) {
            case "1" -> showEnclosure(game);
            case "2" -> doMaintenance(game);
            case "3" -> feedCreature(game);
            case "4" -> healCreature(game);
            case "5" -> transferCreature(game);
            case "6" -> addEnclosure(game);
            case "7" -> addCreature(game);
            case "8" -> {
                System.out.println("Merci d'avoir joué à Idle Zoo Fantastique Tycoon!");
                System.out.println("À bientôt!");
                System.out.println("D'ailleurs, vos données ont bien " + boldText("pas") + " été sauvegardées.");
                ConsoleTricks.waitEnter(true);
                System.exit(0);
            }
            default -> {
                System.out.println("L'option que vous avez choisi n'existe pas, rentrer un chiffre entre 1 et .");
                ConsoleTricks.waitEnter(true);
                displayMainMenu(game);
            }
        }
    }

    // TODO : doc
    public static void showEnclosure(Game game) {
        int choice = -1;
        do {
            System.out.println("Voici la liste des enclos de " + boldText(game.getZoo().getZooName()) + ":");
            for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
                System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(i).getName()));
            }
            System.out.println("Quel enclos voulez-vous afficher?");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice < 0 || choice >= game.getZoo().getEnclosures().size());
        System.out.println("Enclos " + boldText(game.getZoo().getEnclosures().get(choice).getName()) + ":");
        System.out.println(game.getZoo().getEnclosures().get(choice));

        waitEnter("retourner au menu", true);
        displayMainMenu(game);
    }

    // TODO : doc
    public static void doMaintenance(Game game) {
        int choice = -1;
        do {
            System.out.println("Voici la liste des enclos de " + boldText(game.getZoo().getZooName()) + ":");
            for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
                System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(i).getName()));
            }
            System.out.println("Quel enclos voulez-vous maintenir?");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice < 0 || choice >= game.getZoo().getEnclosures().size());
        game.getZoo().getEnclosures().get(choice).maintenance();

        waitEnter("retourner au menu", true);
        displayMainMenu(game);
    }

    // TODO : doc
    public static void feedCreature(Game game) {
        int choice = -1;
        do {
            System.out.println("Voici la liste des enclos de " + boldText(game.getZoo().getZooName()) + ":");
            for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
                System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(i).getName()));
            }
            System.out.println("Dans quel enclos voulez-vous nourrir une créature?");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice < 0 || choice >= game.getZoo().getEnclosures().size());
        int choice2 = -1;
        do {
            displayEnclosureCreature(game, choice);
            System.out.println("Quelle créature voulez-vous nourrir?");
            try {
                choice2 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice2 < 0 || choice2 >= game.getZoo().getEnclosures().get(choice).getListCreature().size());
        game.getZoo().getEnclosures().get(choice).getListCreature().get(choice2).feed(new Beefsteak());

        waitEnter("retourner au menu", true);
        displayMainMenu(game);
    }

    public static void healCreature(Game game) {
        int choice = -1;
        do {
            System.out.println("Voici la liste des enclos de " + boldText(game.getZoo().getZooName()) + ":");
            for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
                System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(i).getName()));
            }
            System.out.println("Dans quel enclos voulez-vous soigner une créature?");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice < 0 || choice >= game.getZoo().getEnclosures().size());
        int choice2 = -1;
        do {
            displayEnclosureCreature(game, choice);
            System.out.println("Quelle créature voulez-vous soigner?");
            try {
                choice2 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice2 < 0 || choice2 >= game.getZoo().getEnclosures().get(choice).getListCreature().size());

        if (game.getZoo().getEnclosures().get(choice).getListCreature().get(choice2).isSick())
            game.getZoo().getEnclosures().get(choice).getListCreature().get(choice2).heal();
        else
            System.out.println("La créature n'est pas malade.");

        waitEnter("retourner au menu", true);
        displayMainMenu(game);
    }

    // TODO : doc
    public static void transferCreature(Game game) {
        Scanner scanner = new Scanner(System.in);
        int sourceEnclosureIndex = -1;
        int creatureIndex = -1;
        int destinationEnclosureIndex = -1;

        if (game.getZoo().getEnclosures().size() < 2) {
            System.out.println("Vous n'avez pas assez d'enclos pour transférer une créature, veuillez en créer un autre.");
            waitEnter(true);
            displayMainMenu(game);
        }
        // Select the source enclosure
        do {
            System.out.println("Sélectionnez un enclos source:");
            sourceEnclosureIndex = getEnclosureIndex(game, scanner, sourceEnclosureIndex);
        } while (sourceEnclosureIndex < 0 || sourceEnclosureIndex >= game.getZoo().getEnclosures().size());

        // Select the creature to transfer
        do {
            System.out.println("Séléctionnez une créature à transférer:");
            for (int i = 0; i < game.getZoo().getEnclosures().get(sourceEnclosureIndex).getListCreature().size(); i++) {
                System.out.println(i + " - " + game.getZoo().getEnclosures().get(sourceEnclosureIndex).getListCreature().get(i).getName());
            }
            try {
                creatureIndex = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (creatureIndex < 0 || creatureIndex >= game.getZoo().getEnclosures().get(sourceEnclosureIndex).getListCreature().size());

        // Select the destination enclosure
        do {
            System.out.println("Sélectionnez un enclos de destination:");
            for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
                if (i != sourceEnclosureIndex) {
                    System.out.println(i + " - " + game.getZoo().getEnclosures().get(i).getName());
                }
            }
            try {
                destinationEnclosureIndex = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (destinationEnclosureIndex < 0 || destinationEnclosureIndex >= game.getZoo().getEnclosures().size() || destinationEnclosureIndex == sourceEnclosureIndex);

        // Transfer the creature
        Creature creature = game.getZoo().getEnclosures().get(sourceEnclosureIndex).getListCreature().remove(creatureIndex);
        game.getZoo().getEnclosures().get(destinationEnclosureIndex).getListCreature().add(creature);

        System.out.println("La créature " + creature.getName() + " a été transférée de l'enclos " + game.getZoo().getEnclosures().get(sourceEnclosureIndex).getName() + " à l'enclos " + game.getZoo().getEnclosures().get(destinationEnclosureIndex).getName() + ".");

        waitEnter(true);
        displayMainMenu(game);
    }

    // TODO : doc
    public static void addEnclosure(Game game) {
        String enclosureType;
        String enclosureName;
        do {
            System.out.println("Quel est le nom de l'enclos?");
            enclosureName = scanner.nextLine();

            System.out.println("Quel est le type de l'enclos?");
            System.out.println("1 - Enclos Terrestre");
            System.out.println("2 - Volière");
            System.out.println("3 - Aquarium");

            enclosureType = scanner.nextLine();
            if (!enclosureType.equals("1") && !enclosureType.equals("2") && !enclosureType.equals("3")) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (!enclosureType.equals("1") && !enclosureType.equals("2") && !enclosureType.equals("3"));

        switch (enclosureType) {
            case "1" -> game.getZoo().addEnclosure(new Enclosure<>(enclosureName, 20, 10));
            case "2" -> game.getZoo().addEnclosure(new AviaryEnclosure<>(enclosureName, 20, 10, 5));
            case "3" -> game.getZoo().addEnclosure(new AquariumEnclosure<>(enclosureName, 20, 10, 5));
        }

        waitEnter(true);
        displayMainMenu(game);
    }

    // TODO : doc
    public static void addCreature(Game game) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est le nom de la créature?");
        String creatureName = scanner.nextLine();

        System.out.println("Entrez le sexe de votre créature, tapez F pour femelle et M pour mâle:");
        String sexeLetter = scanner.nextLine();
        Gender sexe;
        if (sexeLetter.equalsIgnoreCase("f")) {
            sexe = Gender.FEMALE;
        } else {
            sexe = Gender.MALE;
        }
        
        int creatureType = -1;
        do {
            System.out.println("Quel est le type de la créature?");
            System.out.println("1 - Lycanthrope");
            System.out.println("2 - Sirène");
            System.out.println("3 - Nymphe");
            System.out.println("4 - Licorne");
            System.out.println("5 - Dragon");
            System.out.println("6 - Kraken");
            System.out.println("7 - Megalodon");
            System.out.println("8 - Phoenix");
            try {
                creatureType = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (creatureType < 1 || creatureType > 8);

        Creature creature;
        switch (creatureType) {
            case 1 -> creature = new Lycanthrope(creatureName, sexe);
            case 2 -> creature = new Mermaid(creatureName, sexe);
            case 3 -> creature = new Nymph(creatureName, sexe);
            case 4 -> creature = new Unicorn(creatureName, sexe);
            case 5 -> creature = new Dragon(creatureName, sexe);
            case 6 -> creature = new Kraken(creatureName, sexe);
            case 7 -> creature = new Megalodon(creatureName, sexe);
            case 8 -> creature = new Phoenix(creatureName, sexe);
            default -> creature = null;
        }

        int enclosureIndex = -1;
        do {
            System.out.println("Dans quel enclos voulez-vous placer la créature?");
            enclosureIndex = getEnclosureIndex(game, scanner, enclosureIndex);
        } while (enclosureIndex < 0 || enclosureIndex >= game.getZoo().getEnclosures().size());

        game.getZoo().getEnclosures().get(enclosureIndex).addCreature(creature);

        waitEnter(true);
        displayMainMenu(game);
    }

    private static void displayEnclosureCreature(Game game, int choice) {
        System.out.println("Voici la liste des créatures de l'enclos " + boldText(game.getZoo().getEnclosures().get(choice).getName()) + ":");
        for (int i = 0; i < game.getZoo().getEnclosures().get(choice).getListCreature().size(); i++) {
            System.out.println(i + " - " + boldText(game.getZoo().getEnclosures().get(choice).getListCreature().get(i).getName()));
        }
    }

    // TODO : doc
    private static int getEnclosureIndex(Game game, Scanner scanner, int enclosureIndex) {
        for (int i = 0; i < game.getZoo().getEnclosures().size(); i++) {
            System.out.println(i + " - " + game.getZoo().getEnclosures().get(i).getName());
        }
        try {
            enclosureIndex = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
        return enclosureIndex;
    }
}
