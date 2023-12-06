package net.zoofantastique.view;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;
import java.util.Scanner;
import static net.zoofantastique.view.ConsoleTricks.*;

public class Tuto {

    public void start(Game game) {
        step1ZooMasterCreation(game);
        step2ZooFantastiqueCreation(game);
        step3EnclosureCreation(game);
        step4AddCreature(game);
    }

    public void step1ZooMasterCreation(Game game) {
        System.out.println("Bienvenue! Ceci est un tutoriel pour vous aider à démarrer votre premier zoo, suivez les instructions à l'écran pour continuer.");

        System.out.println("Entrez le nom de votre premier personnage:");
        String zooMasterName = scan();

        System.out.println("Si vous voulez créer une Femme tapez F, sinon M:");
        String zooMasterSexChoice = scan();

        // C'est un if ternaire, c'est comme un if mais en plus court
        Gender zooMasterSex = (zooMasterSexChoice.equalsIgnoreCase("f")) ? Gender.FEMALE : Gender.MALE;

        ZooMaster zooMaster = new ZooMaster(zooMasterName, zooMasterSex, Age.ADULT);
        System.out.println("Merci! Votre personnage est maintenant créé, voici un résumé de ses informations:\n" + zooMaster);
        game.setZooMaster(zooMaster);

        waitEnter(true);
    }

    public void step2ZooFantastiqueCreation(Game game) {
        System.out.println("Maintenant que votre personnage est créé, il est temps de créer votre premier zoo!");
        System.out.println("\nEntrez le nom de votre zoo:");

        String zooName = scan();

        Zoo zoo = new Zoo(zooName, game.getZooMaster());
        game.setZoo(zoo);

        waitEnter(true);
    }

    public void step3EnclosureCreation(Game game) {
        System.out.println("Maintenant que votre zoo est créé, il est temps de créer votre premier enclos!");
        System.out.println("\nEntrez le nom de votre enclos:");

        String enclosureName = scan();

        Enclosure<? super Creature> enclosure = new Enclosure<>(enclosureName, 20, 5);

        System.out.println("Votre enclos est maintenant créé, voici un résumé de ses informations:\n" + enclosure);
        game.getZoo().addEnclosures(enclosure);

        waitEnter(true);
    }

    public void step4AddCreature(Game game) {
        System.out.println("Maintenant que votre enclos est créé, il est temps d'ajouter votre première créature!");
        System.out.println("\nPour votre première créature nous allons vous donnez un Dragon car c'est le plus polyvalent, vous pourrez en ajouter d'autres plus tard.");

        System.out.println("\nEntrez le nom de votre créature:");
        String creatureName = scan();

        System.out.println("\nEntrez le sexe de votre créature, tapez F pour femelle et M pour mâle:");
        String sexeLetter = scan();
        Gender sexe;
        if (sexeLetter.equalsIgnoreCase("f")) {
            sexe = Gender.FEMALE;
        }
        else {
            sexe = Gender.MALE;
        }

        game.getZoo().getEnclosures().get(0).addCreature(new Dragon(creatureName, sexe, 2,2));

        System.out.println("Votre créature est maintenant créée, voici un résumé de ses informations:\n" + game.getZoo().getEnclosures().get(0).getListCreature().get(0));

        waitEnter(true);
    }
}
