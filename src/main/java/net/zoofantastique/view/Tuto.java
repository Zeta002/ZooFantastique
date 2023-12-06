package net.zoofantastique.view;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;

import java.util.Scanner;

public class Tuto <T extends Creature> {
    public void step1ZooMasterCreation(Game game) {
        System.out.println("Bienvenue! Ceci est un tutoriel pour vous aider à démarrer votre premier zoo, suivez les instructions à l'écran pour continuer.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom de votre premier personnage:");
        String zooMasterName = scanner.nextLine();

        System.out.println("Si vous voulez créer une Femme tapez F, sinon M:");
        String zooMasterAgeLetter = scanner.nextLine();
        Gender zooMasterSex;
        if (zooMasterAgeLetter.equalsIgnoreCase("f")) {
            zooMasterSex = Gender.FEMALE;
        } else {
            zooMasterSex = Gender.MALE;
        }

        ZooMaster zooMaster = new ZooMaster(zooMasterName, zooMasterSex, Age.ADULT);
        System.out.println("Merci! Votre personnage est maintenant créé, voici un résumé de ses informations:\n" + zooMaster);
        game.setZooMaster(zooMaster);
    }

    public void step2ZooFantastiqueCreation(Game game) {
        System.out.println("Maintenant que votre personnage est créé, il est temps de créer votre premier zoo!");
        System.out.println("\nEntrez le nom de votre zoo:");

        Scanner scanner = new Scanner(System.in);
        String zooName = scanner.nextLine();

        Zoo zoo = new Zoo(zooName, game.getZooMaster());
        game.setZoo(zoo);
    }

    public void step3EnclosureCreation(Game game) {
        System.out.println("Maintenant que votre zoo est créé, il est temps de créer votre premier enclos!");
        System.out.println("\nEntrez le nom de votre enclos:");

        Scanner scanner = new Scanner(System.in);
        String enclosureName = scanner.nextLine();

        Enclosure<T> enclosure = new Enclosure<T>(enclosureName, 20, 5);

        System.out.println("Votre enclos est maintenant créé, voici un résumé de ses informations:\n" + enclosure);
        game.getZoo().addEnclosure(enclosure);
    }

    public void step4AddCreature(Game game) {
        System.out.println("Maintenant que votre enclos est créé, il est temps d'ajouter votre première créature!");
        System.out.println("\nPour votre première créature nous allons vous donnez un Dragon car c'est le plus polyvalent, vous pourrez en ajouter d'autres plus tard.");

        System.out.println("\nEntrez le nom de votre créature:");
        Scanner scanner = new Scanner(System.in);
        String creatureName = scanner.nextLine();

        System.out.println("\nEntrez le sexe de votre créature, tapez F pour femelle et M pour mâle:");
        String sexeLetter = scanner.nextLine();
        Gender sexe;
        if (sexeLetter.equalsIgnoreCase("f")) {
            sexe = Gender.FEMALE;
        }
        else {
            sexe = Gender.MALE;
        }

        ((Enclosure<Dragon>)game.getZoo().getEnclosures().get(0)).addCreature(new Dragon(creatureName, sexe, 2, 2));
    }
}
