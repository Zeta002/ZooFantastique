package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.enclosure.behavior.Salinity;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;
import net.zoofantastique.controller.entity.creature.composition.Creature;

import java.util.concurrent.TimeUnit;

/**
 * Classe AquariumEnclosure qui représente un aquarium dans un zoo.
 * Un aquarium est un type d'enclos qui a une profondeur de bassin et une salinité de bassin en plus des attributs d'un enclos.
 * Cette classe étend la classe Enclosure.
 */
public class AquariumEnclosure<T extends Creature> extends Enclosure<T> {
    private double basinDepth; // Profondeur du bassin en mètres
    private Salinity basinSalinity; // Salinité du bassin

    // Constructeur
    public AquariumEnclosure(String name, double surface, double basinDepth, int max) {
        super(name, surface, max);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    @Override
    public void run() {
        super.run();
        getExecutor().scheduleAtFixedRate(() -> {
            this.setBasinSalinity(getBasinSalinity().decrement());
        }, 120,  121, TimeUnit.SECONDS);
    }

    /**
     * Ajoute une créature à l'enclos si elle est capable de nager et s'il y a suffisamment de place dans l'enclos.
     * Si la créature ne peut pas nager, une erreur est affichée.
     * Si l'enclos est plein, une erreur est affichée.
     *
     * @param creature La créature à ajouter à l'enclos.
     */
    @Override
    public void addCreature(T creature) {
        if (getListCreature().isEmpty()) {
            setCreatureType(creature.getClass());
        }
        if (getCreatureType().equals(creature.getClass())) {
            if (creature instanceof Swimmer) {
                if (getNbCreature() < getMax()) {
                    this.getListCreature().add(creature);
                    setNbCreature(getNbCreature() + 1);
                } else {
                    System.err.println("Pas assez de places disponibles!");
                }
            } else {
                System.err.println("La créature:\n" + creature + "\nne peut pas nager et ne peut donc pas être ajoutée à l'aquarium!");
            }
        } else {
            System.err.println("L'enclos ne peux pas accueillir plusieurs types de créatures!");
        }
    }

    // TODO : doc
    public void maintenance() {
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        performMaintenanceBasedOnDepth();
    }

    // TODO plus la profondeur est grande plus le thread prend du temps
    // TODO : doc
    private void performMaintenanceBasedOnDepth() {
        if (basinDepth <= 80) {
            setBasinSalinity(basinSalinity.increment());
        } else if (basinDepth > 80 && basinDepth <= 100) {
            setBasinSalinity(basinSalinity.increment());
        } else if (basinDepth > 100 && basinDepth <= 120) {
            setBasinSalinity(basinSalinity.increment());
        } else if (basinDepth > 120) {
            setBasinSalinity(basinSalinity.increment());
        }
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getBasinSalinity().getValue() + ".");
    }

    // Getter et setter

    public double getBasinDepth() {
        return basinDepth;
    }
    public void setBasinDepth(double basinDepth) {
        this.basinDepth = basinDepth;
    }

    public Salinity getBasinSalinity() {
        return basinSalinity;
    }
    public void setBasinSalinity(Salinity basinSalinity) {
        this.basinSalinity = basinSalinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<-/ " + getEnclosureType() + " \\->\n");
        if (getListCreature().isEmpty()) {
            sb.append("-------------------------")
            .append("\nNom: ").append(getName())
            .append("\nSuperficie: ").append(getSurface()).append("m²")
            .append("\nMax creatures: ").append(getMax())
            .append("\nNb creatures: ").append(getNbCreature())
            .append(" / ").append(getMax())
            .append("\nPropreté: ").append(getCleanness().getValue())
            .append("\nProfondeur: ").append(getBasinDepth()).append("m")
            .append("\nSalinité: ").append(getBasinSalinity().getValue()).append("\n");
        } else {
            sb.append("-------------------------")
            .append("\nNom: ").append(getName())
            .append("\nSuperficie: ").append(getSurface()).append("m²")
            .append("\nMax creatures: ").append(getMax())
            .append("\nNb creatures: ").append(getNbCreature())
            .append(" / ").append(getMax())
            .append("\nPropreté: ").append(getCleanness().getValue())
            .append("\nProfondeur: ").append(getBasinDepth()).append("m")
            .append("\nSalinité: ").append(getBasinSalinity().getValue())
            .append("\n\nListes des créatures:\n\n")
            .append(showCreatures());
        }
        return sb.toString();
    }
}
