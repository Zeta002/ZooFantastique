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
    private CoupleAlpha couple; // couple dominant (alpha) de la meute
    private final List<Lycanthrope> lycanthropes; // liste des lycanthropes de la meute
    private Lycanthrope maleAlpha; // mâle alpha de la meute
    private Lycanthrope femaleAlpha; // femelle alpha de la meute

    // Constructeur
    public Pack(String packName, CoupleAlpha couple) {
        this.packName = packName;
        this.couple = couple;
        this.lycanthropes = new ArrayList<>();
        initPack();
    }

    public Pack(String packName, Lycanthrope male, Lycanthrope female) {
        this.packName = packName;
        this.couple = new CoupleAlpha(male, female);
        this.lycanthropes = new ArrayList<>();
        initPack();
    }

    // Méthodes

    // TODO : doc
    public void initPack() {
        this.maleAlpha = couple.getFirst();
        this.femaleAlpha = couple.getSecond();
        this.lycanthropes.add(couple.getFirst());
        this.lycanthropes.add(couple.getSecond());
    }

    // TODO : doc
    public void addLycanthrope(Lycanthrope lycanthrope) {
        battle(lycanthrope, maleAlpha);
        this.lycanthropes.add(lycanthrope);
    }

    // TODO : doc
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        if (!this.lycanthropes.remove(lycanthrope)) System.err.println("Le lycanthrope " + lycanthrope.getName() + " n'est pas dans la meute.");
    }

    // TODO : doc
    public void swapRank(Lycanthrope l1, Lycanthrope l2) {
        int rank = l1.getRank();
        l1.setRank(l2.getRank());
        l2.setRank(rank);
    }

    // TODO : doc
    public void battle(Lycanthrope l1, Lycanthrope l2) {
        if (l1.equals(femaleAlpha) || l2.equals(femaleAlpha)) {
            System.err.println("L'un des deux lycanthrope est la femelle alpha et ne peut donc pas se battre.");
            return;
        } else if (l1.getSexe() != l2.getSexe()) {
            System.err.println("Les deux lycanthropes ne sont pas du même sexe.");
            return;
        }

        if (l1.getLevel() > l2.getLevel()) {
            rankReassignment(l1, l2);
        } else if (l1.getLevel() < l2.getLevel()) {
            rankReassignment(l2, l1);
        } else if ((l1.getLevel() == l2.getLevel()) && (l1.equals(maleAlpha) || l2.equals(maleAlpha))) {
            if (l1.equals(maleAlpha)) {
                l2.setRank(l1.getRank() + 1);
                newCoupleAlpha(l2);
            } else {
                l1.setRank(l2.getRank() + 1);
                newCoupleAlpha(l1);
            }
        } else {
            System.err.println("Les deux lycanthropes sont de même niveau.");
        }
    }

    // TODO : doc
    public void rankReassignment(Lycanthrope winner, Lycanthrope loser) {
        if (loser.equals(maleAlpha)) {
            femaleAlpha.setRank(femaleAlpha.getRank() + 1);
            newCoupleAlpha(winner);
        }
        if (winner.getRank() >= loser.getRank()) {
            loser.setRank(loser.getRank() - 1);
        } else {
            swapRank(winner, loser);
        }
        winner.setDominanceFactor(winner.getDominanceFactor() + 1);
        loser.setDominanceFactor(loser.getDominanceFactor() - 1);
    }

    public void newCoupleAlpha(Lycanthrope maleAlpha) {
        Lycanthrope bestFemale = null;
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope.getSexe().equals(Gender.FEMALE)) {
                if (bestFemale == null) bestFemale = lycanthrope;
                if (lycanthrope.getLevel() > bestFemale.getLevel()) {
                    bestFemale = lycanthrope;
                }
            }
        }
        setCouple(new CoupleAlpha(maleAlpha, bestFemale));
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

    public CoupleAlpha getCouple() {
        return couple;
    }
    public void setCouple(CoupleAlpha couple) {
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
                "\nNombre de lycanthropes: " + lycanthropes.size() +
                "\nListe des lycanthropes: \n" +
                getLycanthropesToString();
    }
}
