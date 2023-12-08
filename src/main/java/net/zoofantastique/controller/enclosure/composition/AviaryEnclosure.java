package net.zoofantastique.controller.enclosure.composition;

import net.zoofantastique.controller.entity.creature.behavior.Flying;
import net.zoofantastique.controller.entity.creature.composition.Creature;

/**
 * Classe AviaryEnclosure qui représente une volière dans un zoo.
 * Une volière est un type d'enclos qui a une hauteur de toit en plus des attributs d'un enclos.
 * Cette classe étend la classe Enclosure.
 */
public class AviaryEnclosure<T extends Creature> extends Enclosure<T> {
    // Attributs

    /**
     * La hauteur du toit de la volière.
     */
    private double roofHeight;

    /**
     * Construit un nouvel AviaryEnclosure avec les paramètres spécifiés.
     *
     * @param name       le nom de la volière
     * @param surface    la surface de la volière en mètres carrésimport net.zoofantastique.controller.creature.behavior.Flying;
     * @param roofHeight la hauteur du toit de la volière en mètres
     * @param max        le nombre maximum de créatures qui peuvent être logées dans la volière
     */
    public AviaryEnclosure(String name, double surface, double roofHeight, int max) {
        super(name, surface, max);
        this.roofHeight = roofHeight;
    }

    // Méthodes

    /**
     * Ajoute une créature à l'enclos si elle est capable de voler et s'il y a suffisamment de place dans l'enclos.
     * Si la créature ne peut pas voler, une erreur est affichée.
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
            // Vérifie si la créature est un Flying
            if (creature instanceof Flying) {
                // Vérifie s'il y a assez de place dans la volière
                if (getNbCreature() < getMax()) {
                    this.getListCreature().add(creature);
                    setNbCreature(getNbCreature() + 1);
                } else {
                    System.err.println("Pas assez de places disponibles!");
                }
            } else {
                // Affiche un message d'erreur si la créature n'est pas un Flying
                System.err.println("La créature:\n" + creature + "\nne peut pas voler et ne peut donc pas être ajoutée à la volière!");
            }
        } else {
            System.err.println("L'enclos ne peux pas accueillir plusieurs types de créatures!");
        }
    }

        public void maintenance () {
            if (getListCreature().isEmpty()) {
                System.out.println(getClass().getSimpleName() + " : " + getName() + " est vide.");
                return;
            }
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est en maintenance.");
            performMaintenanceBasedOnHeight();
        }

        // TODO plus la hauteur est grande plus le thread prend du temps
        private void performMaintenanceBasedOnHeight () {
            if (roofHeight <= 80) {
                setCleanness(getCleanness().clean());
            } else if (roofHeight > 80 && roofHeight <= 100) {
                setCleanness(getCleanness().clean());
            } else if (roofHeight > 100 && roofHeight <= 120) {
                setCleanness(getCleanness().clean());
            } else if (roofHeight > 120) {
                setCleanness(getCleanness().clean());
            }
            System.out.println(getClass().getSimpleName() + " : " + getName() + " est maintenant " + getCleanness().getValue() + ".");
        }

        // Getter et setter

        public double getRoofHeight () {
            return roofHeight;
        }

        public void setRoofHeight ( double roofHeight){
            this.roofHeight = roofHeight;
        }

        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder("<-/ " + getEnclosureType() + " \\->\n");
            if (getListCreature().isEmpty()) {
                sb.append("-------------------------")
                        .append("\nNom: ").append(getName())
                        .append("\nSuperficie: ").append(getSurface()).append("m²")
                        .append("\nMax creatures: ").append(getMax())
                        .append("\nNb creatures: ").append(getNbCreature())
                        .append(" / ").append(getMax())
                        .append("\nPropreté: ").append(getCleanness().getValue())
                        .append("\nHauteur: ").append(getRoofHeight()).append("m").append("\n");
            } else {
                sb.append("-------------------------")
                        .append("\nNom: ").append(getName())
                        .append("\nSuperficie: ").append(getSurface()).append("m²")
                        .append("\nMax creatures: ").append(getMax())
                        .append("\nNb creatures: ").append(getNbCreature())
                        .append(" / ").append(getMax())
                        .append("\nPropreté: ").append(getCleanness().getValue())
                        .append("\nHauteur: ").append(getRoofHeight()).append("m")
                        .append("\n\nListes des créatures:\n\n")
                        .append(showCreatures());
            }
            return sb.toString();
        }
    }