package net.zoofantastique.controller.entity.creature.behavior;

import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe Pack représentant une meute de lycanthropes.
 */
public class Pack {
    // Attributs
    private String packName; // nom de la meute
    private int packSize; // nombre de lycanthropes dans la meute
    private Pair<Lycanthrope, Lycanthrope> couple; // couple dominant (alpha) de la meute
    private final List<Lycanthrope> lycanthropes; // liste des lycanthropes de la meute

    // Constructeur
    // TODO : doc, constructeur en précisant le mal et la femelle en utilisant la classe Pair
    public Pack(String packName, Pair<Lycanthrope, Lycanthrope> couple) {
        this.packName = packName;
        this.packSize = 2;
        this.couple = couple;
        this.lycanthropes = new ArrayList<>();
    }

    // TODO : doc, constructeur en précisant le male et la femelle san utilisé la classe Pair
    public Pack(String packName, Lycanthrope male, Lycanthrope female) {
        this.packName = packName;
        this.packSize = 2;
        this.couple = new Pair<>(male, female);
        this.lycanthropes = new ArrayList<>();
    }

    // Méthodes

    // TODO : doc
    // Inutile ? On peut utiliser la méthode add de la liste en appellant le getter getLycanthropes()
    public void addLycanthrope(Lycanthrope lycanthrope) {
        this.lycanthropes.add(lycanthrope);
        this.packSize++;
    }

    // TODO : doc
    // Inutile ? On peut utiliser la méthode remove de la liste en appellant le getter getLycanthropes()
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        if (this.lycanthropes.remove(lycanthrope)) this.packSize--;
        else System.err.println("Le lycanthrope " + lycanthrope.getName() + " n'est pas dans la meute.");
    }

    // TODO : doc
    public String getLycanthropesToString() {
        StringBuilder sb = new StringBuilder();
        for (Lycanthrope lycanthrope : lycanthropes) {
            sb.append(lycanthrope).append("\n");
        }
        return sb.toString();
    }

    // TODO : doc
    public void displayLycanthropesToString() {
        System.out.println(getLycanthropesToString());
    }

    // TODO : doc
    public void sortByRank() {
        this.lycanthropes.sort(Comparator.comparingInt(Lycanthrope::getRank));
    }

    // TODO : doc
    public void showhierarchy() {
        sortByRank();
        System.out.println("<-/ " + this.packName + " \\->\n");
        for (int i = 0; i < lycanthropes.size(); i++) {
            System.out.println(i + "." + lycanthropes.get(i).getName() + " est un " + lycanthropes.get(i).getRankString() + ".");
        }
    }

    // Getter et setter

    public String getPackName() {
        return packName;
    }
    public void setPackName(String packName) {
        this.packName = packName;
    }

    public int getPackSize() {
        return packSize;
    }

    public Pair<Lycanthrope, Lycanthrope> getCouple() {
        return couple;
    }
    public void setCouple(Pair<Lycanthrope, Lycanthrope> couple) {
        this.couple = couple;
    }

    public List<Lycanthrope> getLycanthropes() {
        return lycanthropes;
    }

    // TODO : doc
    @Override
    public String toString() {
        return "<-/ " + this.packName + " \\->\n" +
                "Couple dominant: " + this.couple +
                "\nNombre de lycanthropes: " + this.packSize +
                "\nListe des lycanthropes: " +
                getLycanthropesToString();
    }
}
