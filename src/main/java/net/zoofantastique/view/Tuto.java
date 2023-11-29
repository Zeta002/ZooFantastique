package net.zoofantastique.view;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;

import java.util.Scanner;

public class Tuto {
    public void step1ZooMasterCreation() {
        System.out.println("Bienvenue! Ceci est un tutoriel pour vous aider à démarrer votre premier zoo, suivez les instructions à l'écran pour continuer.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom de votre premier personnage:");
        String zooMasterName = scanner.nextLine();

        System.out.println("Si vous voulez créer une Femme tapé F, sinon M:");
        String zooMasterAgeLetter = scanner.nextLine();
        Gender zooMasterSex = null;
        if (zooMasterAgeLetter.equalsIgnoreCase("f")) {
            zooMasterSex = Gender.FEMALE;
        } else {
            zooMasterSex  = Gender.MALE;
        }

        ZooMaster firstZooMaster = new ZooMaster(zooMasterName, zooMasterSex, Age.ADULT);
        System.out.println("Merci! Votre personnage est maintenant créé, voici un résumé de ses informations:\n" + firstZooMaster);
    }

    public void step2ZooFantastiqueCreation() {
        // TODO
    }
}
