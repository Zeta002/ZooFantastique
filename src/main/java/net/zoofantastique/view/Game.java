package net.zoofantastique.view;

import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;

/**
 * Classe Game qui représente le jeu.
 * Cette classe contient les méthodes permettant de lancer le jeu.
 */
public class Game implements ConsoleTricks {
    // Attributs
    private Zoo zoo;
    private ZooMaster zooMaster;

    // Méthodes

    public void start() {
        Tuto tuto = new Tuto();

        tuto.start(this);

        MenuZooMaster.displayMainMenu(this);
    }

    // Getter et setter

    public Zoo getZoo() {
        return zoo;
    }
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public ZooMaster getZooMaster() {
        return zooMaster;
    }
    public void setZooMaster(ZooMaster zooMaster) {
        this.zooMaster = zooMaster;
    }
}
