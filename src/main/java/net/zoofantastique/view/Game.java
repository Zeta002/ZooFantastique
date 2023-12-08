package net.zoofantastique.view;

import net.zoofantastique.controller.entity.zoomaster.ZooMaster;
import net.zoofantastique.controller.zoo.Zoo;
import net.zoofantastique.simulation.Simulation;

public class Game implements ConsoleTricks {
    private Zoo zoo;
    private ZooMaster zooMaster;

    public void start() {
        Tuto tuto = new Tuto();

        tuto.start(this);

        Simulation simulation = new Simulation(this);

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
