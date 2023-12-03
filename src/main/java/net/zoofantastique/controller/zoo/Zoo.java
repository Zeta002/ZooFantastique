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


    public Zoo(String zooName, ZooMaster zooMaster, int maxNbEnclosure){
        this.zooName = zooName;
        this.zooMaster = zooMaster;
        this.maxNbEnclosure = maxNbEnclosure;

        this.zooEnclosures = new ArrayList<>();
    }

    /**
     * Cette fonction sert à compter le nombre de crétures présentent dans le zoo
     * elle parcourt la list d'enclos en comptant le nombre de créture contenue dans chacun d'entre eux
     * @return total un int qui est le total de crétures
     */
    public int giveNbCreatures(){
        int total = 0;
        for (Enclosure enclosure : zooEnclosures){
            total += enclosure.getNbCreature();
        }
        return total;
    }

    /**
     * Cette méthode est utilisée pour afficher les enclos du zoo
     * si le zoo possède au moins 1 enclos elle les affichent en utilisant leur toString
     * sinon elle affiche un message disant que le zoo est vide
     */
    public void displayEnclosures() {
        if(zooEnclosures.size() != 0){
            for(Enclosure enclosure : zooEnclosures) {
                System.out.println("\t" + enclosure);
            }
        }
        else{
            System.out.println(zooName + " ne possède pas d'enclo.");
        }
    }

    /**
     * Cette méthode est utilisée pour ajouter des enclos à notre zoo.
     * Elle accepte un tableau de'enclos et vérifie si le zoo a la capacité d'accueillir touts les enclos.
     * Si le zoo a la capacité, touts les enclos sont ajoutés au zoo.
     * Si le zoo n'a pas la capacité, un message d'erreur est affiché.
     *
     * @param enclosures Un tableau d'enclos à ajouter au zoo.
     */
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
