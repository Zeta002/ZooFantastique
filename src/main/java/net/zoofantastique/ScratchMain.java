package net.zoofantastique;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Dragon;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;
import net.zoofantastique.view.Game;
import net.zoofantastique.view.Terminal;

public class ScratchMain {
    public static void main(String[] args) {
        System.out.println("start");
        Terminal terminal = new Terminal();
        Terminal terminal2 = new Terminal();

        terminal.send("Hello");
        terminal2.send("Hello 2");

        System.out.println("end");

        try {
            // Pause pour 5 secondes
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        Game game = new Game();
//        game.start();
//        Tuto tuto = new Tuto();

//        tuto.step1ZooMasterCreation();

//        MenuZooMaster menuZooMaster = new MenuZooMaster();

//        ZooMaster zooMaster = new ZooMaster("Gérard", Gender.MALE, Age.ADULT);
//        menuZooMaster.displayMenu(zooMaster);

//        menuZooMaster.menuOptions();
//
//        Zoo<Creature> z1 = new Zoo<>("test", zooMaster, 10);
//        z1.displayCreatures();
//        Enclosure<Creature> d1 = new Enclosure<>("enclo1", 2.2, 2);
//        Enclosure<Creature> d2 = new Enclosure<>("enclo2", 2.2, 2);
//        Enclosure<Creature> d3 = new Enclosure<>("enclo3", 2.2, 2);
//        System.out.println("Test");
//        z1.addEnclosure(d1);
//        z1.addEnclosure(d2,d3);
//
//        Dragon d = new Dragon("Gérard leDragon", Gender.FEMALE, 2, 2);
//        d1.addCreatures(d);
//
//        z1.displayCreatures();
    }
}
