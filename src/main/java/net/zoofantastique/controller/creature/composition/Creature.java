package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Hunger;
import net.zoofantastique.controller.creature.consumable.composition.Food;

import static net.zoofantastique.controller.creature.behavior.Hunger.*;

/**
 * Classe abstraite Creature qui représente une créature dans un zoo.
 * Une créature a une espèce, un nom, un sexe, un âge, un cri, un poids, une taille, un état de sommeil, un état de santé, un état de grossesse et un état de faim.
 * Cette classe étend la classe Alive.
 */
public abstract class Creature extends Alive {
    // Attributs

    // Le cri de la créature.
    private final String shout;
    // Le poids de la créature en kilogrammes.
    private double weight;
    // La taille de la créature en mètres.
    private double height;
    // L'état de sommeil de la créature, true si la créature dort, false sinon.
    private boolean isSleeping;
    // L'état de santé de la créature, true si la créature est malade, false sinon.
    private boolean isSick;
    // L'état de grossesse de la créature, true si la créature est en ceinte, false sinon.
    private boolean isPregnant;

    // Attributs speciaux type enumeration
    private Hunger hunger;

    /**
     * Constructeur de la classe Creature avec nom, sexe, poids, taille et cri.
     * Initialise également l'état de sommeil à false (éveillé), l'état de santé à false (non malade) et la faim à SATISFIED (rassasié).
     *
     * @param name   le nom de la créature.
     * @param sexe   le sexe de la créature, peut être Male ou Femelle.
     * @param weight le poids de la créature en kilogrammes.
     * @param height la taille de la créature en mètres.
     * @param shout  le cri de la créature.
     */
    public Creature(String name, Gender sexe, double weight, double height, String shout) {
        super(name, sexe, Age.BABY);

        this.weight = weight;
        this.height = height;
        this.shout = shout;

        this.isSleeping = false;
        this.isSick = false;

        this.hunger = SATISFIED;
    }

    // Methodes

    /**
     * Méthode pour nourrir une créature avec de la nourriture.
     * Si la créature dort, un message est affiché et la méthode se termine.
     * Sinon, la valeur de la faim de la créature est augmentée de la valeur de la nourriture.
     * Ensuite, en fonction de la nouvelle valeur de la faim, l'état de la faim de la créature est mis à jour.
     *
     * @param food La nourriture à donner à la créature.
     */
    public void eat(Food food) {
        if (isSleeping) {
            System.out.println("Tu ne peux pas faire ça car la créature sélectionner dors actuellement.");
            return;
        }

        int totalHungerValue = this.hunger.getHungerValue() + food.getValue();

        if (totalHungerValue >= 10) {
            this.hunger.setValue(10);
            setHunger(SATISFIED);
        } else if (totalHungerValue > 3) {
            this.hunger.setValue(totalHungerValue);
            setHunger(MEDIUM);
        } else {
            this.hunger.setValue(totalHungerValue);
            setHunger(HUNGRY);
        }
    }

    /**
     * Méthode pour faire crier une créature.
     * Affiche un message indiquant que la créature fait son cri.
     */
    public void shout()
    {
        System.out.println(name + " fait " + shout);
    }

    /**
     * Méthode pour guérir une créature.
     * Cette méthode met à jour l'état de santé de la créature à false, indiquant qu'elle n'est plus malade.
     */
    public void healed() {
        isSick = false;
    }

    /**
     * Méthode pour basculer l'état de sommeil d'une créature.
     * Si la créature dort, elle se réveille. Si elle est éveillée, elle s'endort.
     */
    public void toggleSleeping() {
        isSleeping = !isSleeping;
    }

    /**
     * Méthode pour faire vieillir une créature.
     * Cette méthode met à jour l'âge de la créature à l'âge suivant dans l'énumération Age.
     */
    public void aging() {
        this.age = this.age.nextAge();
    }

    /**
     * Méthode pour vérifier si une créature est malade.
     * Si la créature est malade, son âge est défini sur DEAD, ce qui signifie qu'elle est morte.
     */
    public void checkSick() {
        if (isSick) {
            age = Age.DEAD;
        }
    }

    /**
     * Méthode pour déterminer si une créature peut être fécondée par une autre créature.
     * Si l'une des deux créatures est déjà enceinte, la méthode renvoie null.
     * Si les deux créatures sont de la même espèce et de sexes différents, la méthode renvoie la créature femelle.
     * Dans tous les autres cas, la méthode renvoie null.
     *
     * @param partenaire La créature avec laquelle vérifier la possibilité de fécondation.
     * @return La créature femelle si la fécondation est possible, null sinon.
     */
    public Creature fertilizable(Creature partenaire) {
        if (partenaire.isPregnant() || this.isPregnant()) return null;

        if (this.getClass().equals(partenaire.getClass())) {
            if (this.getSexe() != partenaire.getSexe()) {
                if (this.getSexe() == Gender.FEMALE) {
                    return this;
                } else {
                    return partenaire;
                }
            }
        }
        return null;
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature.
     * Construit une chaîne de caractères contenant l'espèce, le nom, le sexe, l'âge, le cri, le poids, la taille, l'état de sommeil, l'état de santé et l'état de faim de la créature.
     *
     * @return Une chaîne de caractères représentant la créature.
     */

    // Getter et Setter

    public Age getAge() {
        return age;
    }
    public String getAgeState() {
        return this.age.getValue();
    }
    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Gender getSexe() {
        return this.sexe.getSexe();
    }
    public String getSexeStatus() {
        return this.sexe.getSexeStatus();
    }

    public double getWeight() {
        return this.weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public String getShout() {
        return this.shout;
    }

    public String getHungerState() {
        return hunger.getState();
    }
    public Hunger getHunger() {
        return this.hunger;
    }
    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    public boolean isSleeping() {
        return this.isSleeping;
    }
    public void setSleeping(boolean sleeping) {
        this.isSleeping = sleeping;
    }

    public boolean isSick() {
        return this.isSick;
    }
    public void setSick(boolean sick) {
        checkSick();
        this.isSick = sick;
    }

    public boolean isPregnant() {
        return isPregnant;
    }
    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCri: ").append(shout)
                .append("\nPoids: ").append(weight).append("kg")
                .append("\nTaille: ").append(height).append("m")
                .append("\nDort: ").append(isSleeping ? "Oui" : "Non")
                .append("\nMalade: ").append(isSick ? "Oui" : "Non")
                .append("\nFaim: ").append(hunger.getState());
        return sb.toString();
    }
}
