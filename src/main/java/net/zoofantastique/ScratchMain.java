package net.zoofantastique;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;
import net.zoofantastique.view.MenuZooMaster;
import net.zoofantastique.view.Tuto;

public class ScratchMain {
    public static void main(String[] args) {
//        Tuto tuto = new Tuto();
//
//        tuto.step1ZooMasterCreation();

        MenuZooMaster menuZooMaster = new MenuZooMaster();

        ZooMaster zooMaster = new ZooMaster("Gérard", Gender.MALE, Age.ADULT);
        menuZooMaster.displayMenu(zooMaster);

        //menuZooMaster.menuOptions();

        Zoo z1 = new Zoo("test", zooMaster, 10);
        z1.displayEnclosures();
        Enclosure d1 = new Enclosure<>("enclo1", 2.2, 2);
        Enclosure d2 = new Enclosure<>("enclo2", 2.2, 2);
        Enclosure d3 = new Enclosure<>("enclo3", 2.2, 2);
        z1.addEnclosure(d1);
        z1.addEnclosure(d2,d3);
        z1.displayEnclosures();
    }
}
