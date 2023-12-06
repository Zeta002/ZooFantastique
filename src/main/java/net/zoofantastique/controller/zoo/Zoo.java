package net.zoofantastique.controller.zoo;

import net.zoofantastique.controller.enclosure.composition.Enclosure;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.controller.entity.zoomaster.ZooMaster;

import java.util.ArrayList;
import java.util.List;

public class Zoo <T extends Creature> {

    // Attributs
    // Nom du zoo
    private final String zooName;
    // Maître du zoo
    private final ZooMaster zooMaster;
    // Nb maximum d'enclos du zoo
    private int nbMaxEnclosure;
    // ArrayList d'enclos du zoo
    private ArrayList<Enclosure<T>> zooEnclosures;


    public Zoo(String zooName, ZooMaster zooMaster){
        this.zooName = zooName;
        this.zooMaster = zooMaster;
        this.nbMaxEnclosure = 5;

        this.zooEnclosures = new ArrayList<>();
    }

    // Méthodes

    /**
     * Cette fonction sert à compter le nombre de crétures présentent dans le zoo,
     * elle parcourt la list d'enclos en comptant le nombre de créture contenue dans chacun d'entre eux
     * @return total un int qui est le total de crétures
     */
    public int giveNbCreatures(){
        int total = 0;
        for (Enclosure<T> enclosure : zooEnclosures){
            total += enclosure.getNbCreature();
        }
        return total;
    }

    /**
     * Cette méthode est utilisée pour afficher les creatures du zoo,
     * si le zoo possède au moins 1 creature, elles sont affiché via la méthode showCreatures() de la classe Enclosure
     * sinon elle affiche un message disant que le zoo est vide
     */
    public void displayCreatures() {
        if (!zooEnclosures.isEmpty()){
            for(Enclosure<T> enclosure : zooEnclosures) {
                System.out.println(enclosure.showCreatures());
            }
        }
        else {
            System.err.println(zooName + " ne possède pas d'enclos.");
        }
    }

    /**
     * Cette méthode est utilisée pour ajouter des enclos à notre zoo.
     * Elle accepte un tableau de'enclos et vérifie si le zoo a la capacité d'accueillir tous les enclos.
     * Si le zoo a de la place, tous les enclos sont ajoutés au zoo.
     * Si le zoo n'a pas la place, un message d'erreur est affiché.
     *
     * @param enclosures Un tableau d'enclos à ajouter au zoo.
     */
    @SafeVarargs
    public final void addEnclosure(Enclosure<T>... enclosures) {
        int totalEnclosure = this.zooEnclosures.size() + enclosures.length;
        if (totalEnclosure <= this.nbMaxEnclosure) {
            this.zooEnclosures.addAll(List.of(enclosures));
        } else {
            System.err.println("Pas assez de places disponibles!");
        }
    }

    // Getter et setter

    public String getZooName(){ return this.zooName; }

    public ZooMaster getZooMaster(){ return this.zooMaster; }

    public int getNbMaxEnclosure(){ return this.nbMaxEnclosure; }
    public void setNbMaxEnclosure(int nbMaxEnclosure){ this.nbMaxEnclosure = nbMaxEnclosure; }

    public ArrayList<Enclosure<T>> getEnclosures(){ return this.zooEnclosures; }
}
