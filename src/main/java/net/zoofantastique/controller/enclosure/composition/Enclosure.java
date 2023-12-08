package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.enclosure.behavior.Cleanness;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.ArrayList;
import java.util.List;

import static net.zoofantastique.controller.entity.creature.behavior.Hunger.SATISFIED;

/**
 * Classe Enclosure représentant un enclos dans un zoo.
 * Un enclos a un type, un nom, une surface, un nombre maximum de créatures, un nombre actuel de créatures, une liste de créatures et un niveau de propreté.
 */
public class Enclosure<T extends Creature> {
    // Le type de l'enclos est déterminé par le nom de la classe qui l'étend
    private final String enclosureType = getClass().getSimpleName();
    // Le nom de l'enclos
    private String name;
    // La surface de l'enclos en mètres carrés
    private double surface;
    // Le nombre maximum de créatures que l'enclos peut contenir
    private int max;
    // Le nombre actuel de créatures dans l'enclos
    private int nbCreature;
    // La liste des créatures actuellement dans l'enclos
    private List<T> listCreature;
    // Le niveau de propreté de l'enclos
    private Cleanness cleanness;

    private Class<? extends Creature> creatureType = null;


    /**
     * Constructeur de la classe Enclosure avec nom, surface et nombre maximum de créatures.
     * Initialise également la liste des créatures à une liste vide, le nombre de créatures à 0 et la propreté à CORRECT.
     *
     * @param name    le nom de l'enclos.
     * @param surface la surface de l'enclos en mètres carrés.
     * @param max     le nombre maximum de créatures que l'enclos peut contenir.
     */
    public Enclosure(String name, double surface, int max) {
        this.name = name;
        this.surface = surface;
        this.max = max;
        this.listCreature = new ArrayList<>();
        this.nbCreature = 0;
        this.cleanness = Cleanness.CORRECT;
    }

    /**
     * Ajoute une créature à l'enclos s'il y a suffisamment de place dans l'enclos.
     * Si l'enclos est plein, une erreur est affichée.
     *
     * @param creature La créature à ajouter à l'enclos.
     */
    public void addCreature(T creature) {
        if (getListCreature().isEmpty()) {
            setCreatureType(creature.getClass());
        }
        if (getCreatureType().equals(creature.getClass())) {
            if (nbCreature < max) {
                this.listCreature.add(creature);
                nbCreature += 1;
            } else {
                System.err.println("Pas assez de places disponibles!");
            }
        } else {
            System.err.println("L'enclos ne peux pas accueillir plusieurs types de créatures!");
        }

    }

    public final void removeCreature(T creature) {
        if (listCreature.contains(creature)) {
            listCreature.remove(creature);
            nbCreature--;
        } else {
            System.err.println("La créature:\n\n" + creature + "\nn'est pas dans l'enclos!");
        }
    }

    /**
     * Méthode pour nourrir une créature dans l'enclos.
     * Si la créature est présente dans l'enclos et qu'elle n'est pas rassasiée, elle mange la nourriture fournie.
     * Si la créature n'est pas présente dans l'enclos, un message d'erreur est affiché.
     *
     * @param food     La nourriture à donner à la créature.
     * @param creature La créature à nourrir.
     */
    public void feedCreature(Food food, T creature) {
        if (listCreature.contains(creature)) {
            if (!creature.getHungerState().equals(SATISFIED.getState())) {
                creature.eat(food);
            } else {
                System.err.println("La créature:\n" + creature + "\nn'a pas faim!");
            }
        } else {
            System.err.println("La créature:\n" + creature + "\nn'est pas dans l'enclos!");
        }
    }

    /**
     * Méthode pour effectuer la maintenance de l'enclos.
     * Si l'enclos est vide, une erreur est affichée et la fonction s'arrête.
     * Sinon, affiche un message indiquant que l'enclos est en maintenance, nettoie l'enclos, puis affiche un message indiquant le nouvel état de propreté de l'enclos.
     */
    public void maintenance() {
        if (listCreature.isEmpty()) {
            System.err.println("L'enclos est vide!");
            return;
        }
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        setCleanness(getCleanness().clean());
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
    }

    // TODO doc
    public String showCreatures() {
        StringBuilder sb = new StringBuilder();
        for (T creature : listCreature) {
            sb.append(creature);
        }
        return sb.toString();
    }

    // Getter et setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNbCreature() {
        return nbCreature;
    }

    public void setNbCreature(int nbCreature) {
        this.nbCreature = nbCreature;
    }

    public List<T> getListCreature() {
        return listCreature;
    }

    public Cleanness getCleanness() {
        return cleanness;
    }

    public void setCleanness(Cleanness cleanness) {
        this.cleanness = cleanness;
    }

    public String getEnclosureType() {
        return enclosureType;
    }

    public Class<? extends Creature> getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(Class<? extends Creature> creatureType) {
        this.creatureType = creatureType;
    }

    // TODO doc
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<-/ " + enclosureType + " \\->\n");
        if (listCreature.isEmpty()) {
            sb.append("-------------------------")
                    .append("\nNom: ").append(name)
                    .append("\nSuperficie: ").append(getSurface()).append("m²")
                    .append("\nMax creatures: ").append(getMax())
                    .append("\nNb creatures: ").append(getNbCreature())
                    .append(" / ").append(getMax())
                    .append("\nPropreté: ").append(getCleanness().getValue()).append("\n");
        } else {
            sb.append("-------------------------")
                    .append("\nNom: ").append(name)
                    .append("\nSuperficie: ").append(getSurface()).append("m²")
                    .append("\nMax creatures: ").append(getMax())
                    .append("\nNb creatures: ").append(getNbCreature())
                    .append(" / ").append(getMax())
                    .append("\nPropreté: ").append(getCleanness().getValue())
                    .append("\n\nListes des créatures:\n\n")
                    .append(showCreatures());
        }
        return sb.toString();
    }
}