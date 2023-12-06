package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.enclosure.behavior.Salinity;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;
import net.zoofantastique.controller.entity.creature.composition.Creature;

/**
 * Classe AquariumEnclosure qui représente un aquarium dans un zoo.
 * Un aquarium est un type d'enclos qui a une profondeur de bassin et une salinité de bassin en plus des attributs d'un enclos.
 * Cette classe étend la classe Enclosure.
 */
public class AquariumEnclosure<T extends Creature> extends Enclosure<T> {
    /**
     * La profondeur du bassin dans l'aquarium en mètres.
     */
    private double basinDepth;

    /**
     * La salinité du bassin dans l'aquarium.
     */
    private Salinity basinSalinity;

    /**
     * Construit un nouvel AquariumEnclosure avec les paramètres spécifiés.
     *
     * @param name       le nom de l'aquarium
     * @param surface    la surface de l'aquarium en mètres carrés
     * @param basinDepth la profondeur du bassin dans l'aquarium en mètres
     * @param max        le nombre maximum de créatures qui peuvent être logées dans l'aquarium
     *
     * <p>La salinité du bassin est initialisée à BRACKISHWATER.</p>
     */
    public AquariumEnclosure(String name, double surface, double basinDepth, int max) {
        super(name, surface, max);
        this.basinSalinity = Salinity.BRACKISHWATER;
        this.basinDepth = basinDepth;
    }

    /**
     * Cette méthode est utilisée pour ajouter des créatures à l'enclos de l'aquarium.
     * Elle accepte un tableau de créatures et vérifie si chaque créature est une instance de Swimmer.
     * Si la créature est un Swimmer et qu'il y a assez de place dans l'aquarium, la créature est ajoutée.
     * Si l'aquarium est plein, un message d'erreur est affiché.
     * Si la créature n'est pas un Swimmer, un message d'erreur est affiché.
     *
     * @param creatures Un tableau de créatures à ajouter à l'aquarium.
     */
    @Override
    public void addCreatures(T... creatures) {
        for (T creature : creatures) {
            // Vérifie si la créature est un Swimmer
            if (creature instanceof Swimmer) {
                // Vérifie s'il y a assez de place dans l'aquarium
                if (getNbCreature() + 1 <= getMax()) {
                    // Ajoute la créature à l'aquarium
                    getListCreature().add(creature);
                    // Augmente le nombre de créatures dans l'aquarium
                    setNbCreature(getNbCreature() + 1);
                } else {
                    // Affiche un message d'erreur si l'aquarium est plein
                    System.err.println("Pas assez de places disponibles!");
                }
            } else {
                // Affiche un message d'erreur si la créature n'est pas un Swimmer
                System.err.println("La créature:\n" + creature + "\nne peut pas nager et ne peut donc pas être ajoutée à l'aquarium!");
            }
        }
    }

    public void maintenance() {
        if (getListCreature().isEmpty()) {
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est vide.");
            return;
        }
        System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
        performMaintenanceBasedOnDepth();
    }

    // TODO plus la profondeur est grande plus le thread prend du temps
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
