package net.zoofantastique.controller.entity.creature.composition;

import net.zoofantastique.controller.consumable.composition.Food;
import net.zoofantastique.controller.entity.Alive;
import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Hunger;
import net.zoofantastique.controller.entity.creature.composition.oviparous.Oviparous;
import net.zoofantastique.controller.entity.creature.composition.viviparous.Viviparous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static net.zoofantastique.utils.Utils.*;

/**
 * Classe abstraite Creature qui représente une créature dans un zoo.
 * Une créature a une espèce, un nom, un sexe, un âge, un cri, un poids, une taille, un état de sommeil, un état de santé, un état de grossesse et un état de faim.
 * Cette classe étend la classe Alive.
 */
public abstract class Creature extends Alive implements Runnable {
    // Attributs
    private ArrayList<Double> minHeight = new ArrayList<>(List.of(0.1, 0.8, 1.5, 1.6, 1.6));
    private ArrayList<Double> maxHeight = new ArrayList<>(List.of(0.2, 1.1, 1.8, 2.1, 2.0));
    private ArrayList<Double> minWeight = new ArrayList<>(List.of(2.0, 20.0, 35.0, 50.0, 55.0));
    private ArrayList<Double> maxWeight = new ArrayList<>(List.of(3.5, 35.0, 50.0, 90.0, 95.0));
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
    private int hunger;

    // Pour la simulation
    private ScheduledExecutorService executor;
    private int ageScale;
    private int dimHunger;


    @Override
    public void run() {
        // Diminution de la faim
        executor.scheduleAtFixedRate(() -> {
            setHunger(getHunger() - 1);
            if (getHunger() == 0) {
                haveToGoToTheHell();
            }
        }, (long) (getDimHunger() - 1) *timeControle, (long) getDimHunger() *timeControle, TimeUnit.SECONDS);
        // Devient malade ?
        executor.scheduleAtFixedRate(() -> {
            boolean haveToBeSick = getRandomIntInRange(0, 100) < 3;
            if (haveToBeSick || isSick) {
                haveToGoToTheHell();
            }
            setSick(haveToBeSick);

        }, 99L *timeControle, 100L *timeControle, TimeUnit.SECONDS);
        // Dors ?
        executor.scheduleAtFixedRate(() -> {
            boolean goToSleep = getRandomIntInRange(0, 100) < 5;
            if (goToSleep) {
                toggleSleeping();
            }

        }, 99L *timeControle, 100L *timeControle, TimeUnit.SECONDS);
        // Vieillisement
        executor.scheduleAtFixedRate(this::aging, (long) (getAgeScale() - 1) *timeControle, (long) getAgeScale() *timeControle, TimeUnit.SECONDS);
    }

    /*
     * Il est malheureusement temps de dire au revoir à notre chère créature.
     *
     * Quelle tristesse...
     */
    public void haveToGoToTheHell() {
        setAge(Age.DEAD);
        executor.shutdown();
    }

    /**
     * Constructeur de la classe Creature avec nom, sexe, poids, taille et cri.
     * Initialise également l'état de sommeil à false (éveillé), l'état de santé à false (non malade) et la faim à SATISFIED (rassasié).
     *
     * @param name   le nom de la créature.
     * @param sexe   le sexe de la créature, peut être Male ou Femelle.
     * @param shout  le cri de la créature.
     */
    public Creature(String name, Gender sexe, String shout) {
        super(name, sexe, Age.BABY);

        calcSizeAndWeight();

        this.shout = shout;

        this.isSleeping = false;
        this.isSick = false;

        this.hunger = Hunger.MAX.getValue();

        // Simulation
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.ageScale = 10;
        this.dimHunger = 30;

        this.run();
    }

    // Methodes
    public void calcSizeAndWeight() {
        int age = getAge().index();
        setHeight(getRandomDoubleInRange(this.minHeight.get(age), this.maxHeight.get(age)));
        setWeight(getRandomDoubleInRange(this.minWeight.get(age), this.maxWeight.get(age)));
    }

    /**
     * Méthode pour nourrir une créature avec de la nourriture.
     * Si la créature dort, un message est affiché et la méthode se termine.
     * Sinon, la valeur de la faim de la créature est augmentée de la valeur de la nourriture.
     * Ensuite, en fonction de la nouvelle valeur de la faim, l'état de la faim de la créature est mis à jour.
     *
     * @param food La nourriture à donner à la créature.
     */
    public void feed(Food food) {
        if (isSleeping) {
            System.err.println("Tu ne peux pas faire ça car la créature sélectionner dors actuellement.");
            return;
        } else if (getHunger() == Hunger.MAX.getValue()) {
            System.err.println("La créature sélectionner n'a pas faim.");
            return;
        }
        int totalHungerValue = getHunger() + food.getValue();
        this.setHunger(totalHungerValue);
    }

    /**
     * Méthode pour faire crier une créature.
     * Affiche un message indiquant que la créature fait son cri.
     */
    public void shout()
    {
        System.out.println(getName() + " fait " + shout);
    }

    /**
     * Méthode pour guérir une créature.
     * Cette méthode met à jour l'état de santé de la créature à false, indiquant qu'elle n'est plus malade.
     */
    public void heal() {
        isSick = false;
    }

    /**
     * Méthode pour basculer l'état de sommeil d'une créature.
     * Si la créature dort, elle se réveille. Si elle est éveillée, elle s'endort.
     */
    public void toggleSleeping() {
        if (isSick) {
            System.err.println("La créature sélectionner est malade, elle ne peut pas dormir.");
            return;
        }
        isSleeping = !isSleeping;
    }

    /**
     * Méthode pour faire vieillir une créature.
     * Cette méthode met à jour l'âge de la créature à l'âge suivant dans l'énumération Age.
     */
    public void aging() {
        setAge(getAge().nextAge());
        calcSizeAndWeight();
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
     * Méthode pour initier une grossesse chez une créature vivipare.
     * Cette méthode vérifie d'abord si la fécondation est possible avec le partenaire fourni.
     * Si la fécondation est possible, la créature femelle est mise en état de grossesse et la méthode giveBirth est appelée pour faire naître le bébé.
     * Si la fécondation n'est pas possible, un message est affiché et la méthode renvoie null.
     *
     * @param partenaire La créature avec laquelle vérifier la possibilité de fécondation.
     */
    public void initiatePregnancy(Creature partenaire) {
        Creature female = fertilizable(partenaire);
        if (female == null) {
            // TODO changé le mot en fonction de vivipare ovipare
            System.err.println("L'accouplement semble impossible.");
        } else {
            System.out.println("Un nouvel arrivant semble être prévu pour bientôt!");
            female.setPregnant(true);
            // TODO appelle de la méthode giveBirtg ou eggsHatch
        }
        // TODO temps d'incubation thread
    }

    // Getter et Setter

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
        return Hunger.getStateFromValue(this.hunger);
    }
    public int getHunger() {
        return this.hunger;
    }
    public void setHunger(int hunger) {
        if (hunger > 10) {
            this.hunger = 10;
        }
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
        this.isSick = sick;
    }

    public boolean isPregnant() {
        return isPregnant;
    }
    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public ArrayList<Double> getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(ArrayList<Double> minHeight) {
        this.minHeight = minHeight;
    }

    public ArrayList<Double> getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(ArrayList<Double> maxHeight) {
        this.maxHeight = maxHeight;
    }

    public ArrayList<Double> getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(ArrayList<Double> minWeight) {
        this.minWeight = minWeight;
    }

    public ArrayList<Double> getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(ArrayList<Double> maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getAgeScale() {
        return ageScale;
    }

    public void setAgeScale(int ageScale) {
        this.ageScale = ageScale;
    }

    public int getDimHunger() {
        return dimHunger;
    }

    public void setDimHunger(int dimHunger) {
        this.dimHunger = dimHunger;
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature.
     * Construit une chaîne de caractères contenant l'espèce, le nom, le sexe, l'âge, le cri, le poids, la taille, l'état de sommeil, l'état de santé et l'état de faim de la créature.
     *
     * @return Une chaîne de caractères représentant la créature.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nCri: ").append(shout)
                .append("\nPoids: ").append(weight).append("kg")
                .append("\nTaille: ").append(height).append("m")
                .append("\nDort: ").append(isSleeping ? "Oui" : "Non")
                .append("\nMalade: ").append(isSick ? "Oui" : "Non")
                .append("\nFaim: ").append(this.getHungerState());
        if (this instanceof Viviparous) {
            sb.append("\nDurée de gestation: ").append(Viviparous.gestationDuration).append(" jours");
        } else {
            sb.append("\nDurée d'incubation: ").append(Oviparous.incubationDuration).append(" jours");
        }
        sb.append("\n");
        return sb.toString();
    }
}
