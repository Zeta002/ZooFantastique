package net.zoofantastique.controller.zoo;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private String zooName;
    private ZooMaster zooMaster;
    private int maxNbEnclosure;
    private ArrayList<Enclosure> zooEnclosures;

    private int nbCreature;

    public Zoo(String zooName, ZooMaster zooMaster, int maxNbEnclosure){
        this.zooName = zooName;
        this.zooMaster = zooMaster;
        this.maxNbEnclosure = maxNbEnclosure;

        this.zooEnclosures = new ArrayList<>();
    }

    public int giveNbCreatures(){
        int total = 0;
        for (Enclosure enclosure : zooEnclosures){
            total += enclosure.getNbCreature();
        }
        return total;
    }
    public void displayEnclosures() {

    }
    public void addEnclosure(Enclosure... enclosures) {
        int totalCEnclosure = this.zooEnclosures.size() + enclosures.length;
        if (totalCEnclosure <= this.maxNbEnclosure) {
            this.zooEnclosures.addAll(List.of(enclosures));
            //nbCreature += creatures.length;
        } else {
            System.err.println("Pas assez de places disponibles!");
        }
    }


    public String getZooName(){ return this.zooName; }
    public ZooMaster getZooMaster(){ return this.zooMaster; }
    public int getMaxNbEnclosure(){ return this.maxNbEnclosure; }
    public ArrayList<Enclosure> getEnclosures(){ return this.zooEnclosures; }


}
