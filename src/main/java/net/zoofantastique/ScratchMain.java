package net.zoofantastique;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
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

        menuZooMaster.menuOptions();
    }
}
