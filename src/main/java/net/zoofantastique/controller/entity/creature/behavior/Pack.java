package net.zoofantastique.controller.entity.creature.behavior;

import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Cette classe représente une meute de lycanthropes.
 * Une meute est composée d'un couple alpha et d'une liste de lycanthropes.
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

    /**
     * Cette méthode est utilisée pour initialiser la meute.
     * Elle définit le mâle alpha et la femelle alpha de la meute en utilisant le couple alpha fourni lors de la création de la meute.
     * Ensuite, elle ajoute le mâle alpha et la femelle alpha à la liste des lycanthropes de la meute.
     */
    public void initPack() {
        this.maleAlpha = couple.getFirst();
        this.femaleAlpha = couple.getSecond();
        this.lycanthropes.add(couple.getFirst());
        this.lycanthropes.add(couple.getSecond());
    }

    /**
     * Cette méthode est utilisée pour ajouter un nouveau lycanthrope à la meute.
     * Avant d'ajouter le lycanthrope à la meute, une bataille est simulée entre le nouveau lycanthrope et le mâle alpha actuel.
     * Le résultat de cette bataille peut affecter le rang et le facteur de dominance du nouveau lycanthrope et du mâle alpha.
     *
     * @param lycanthrope Le nouveau lycanthrope à ajouter à la meute.
     */
    public void addLycanthrope(Lycanthrope lycanthrope) {
        battle(lycanthrope, maleAlpha);
        this.lycanthropes.add(lycanthrope);
    }

    /**
     * Cette méthode est utilisée pour retirer un lycanthrope de la meute.
     * Elle prend en paramètre un lycanthrope et tente de le retirer de la liste des lycanthropes de la meute.
     * Si le lycanthrope n'est pas dans la meute, un message d'erreur est affiché.
     *
     * @param lycanthrope Le lycanthrope à retirer de la meute.
     */
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        if (!this.lycanthropes.remove(lycanthrope)) System.err.println("Le lycanthrope " + lycanthrope.getName() + " n'est pas dans la meute.");
    }

    /**
     * This method is used to swap the ranks of two lycanthropes.
     * It takes two parameters, l1 and l2, which are instances of the Lycanthrope class.
     * The method first stores the rank of l1 in a temporary variable, then sets the rank of l1 to the rank of l2, and finally sets the rank of l2 to the value stored in the temporary variable.
     *
     * @param l1 The first lycanthrope whose rank is to be swapped.
     * @param l2 The second lycanthrope whose rank is to be swapped.
     */
    public void swapRank(Lycanthrope l1, Lycanthrope l2) {
        int rank = l1.getRank();
        l1.setRank(l2.getRank());
        l2.setRank(rank);
    }

    /**
     * Cette méthode est utilisée pour simuler une bataille entre deux lycanthropes.
     * Elle vérifie d'abord si l'un des lycanthropes est la femelle alpha ou si les deux lycanthropes ne sont pas du même sexe.
     * Si l'une de ces conditions est vraie, un message d'erreur est affiché et la méthode se termine.
     * Ensuite, elle compare les niveaux des deux lycanthropes pour déterminer le gagnant.
     * Si les deux lycanthropes ont le même niveau et que l'un d'eux est le mâle alpha, le rang du lycanthrope qui n'est pas le mâle alpha est augmenté de 1.
     * Si les deux lycanthropes ont le même niveau et qu'aucun d'eux n'est le mâle alpha, un message d'erreur est affiché.
     *
     * @param l1 Le premier lycanthrope participant à la bataille.
     * @param l2 Le deuxième lycanthrope participant à la bataille.
     */
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

    /**
     * Cette méthode est utilisée pour réaffecter le rang et le facteur de dominance des lycanthropes gagnant et perdant après une bataille.
     * Si le perdant est le mâle alpha, le rang de la femelle alpha est augmenté et un nouveau couple alpha est formé avec le gagnant.
     * Si le rang du gagnant est supérieur ou égal à celui du perdant, le rang du perdant est diminué.
     * Sinon, les rangs du gagnant et du perdant sont échangés.
     * Enfin, le facteur de dominance du gagnant est augmenté et celui du perdant est diminué.
     *
     * @param winner Le lycanthrope qui a gagné la bataille.
     * @param loser Le lycanthrope qui a perdu la bataille.
     */
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

    /**
     * Cette méthode est utilisée pour créer un nouveau couple alpha dans la meute.
     * Elle prend en paramètre le mâle alpha et détermine la femelle ayant le niveau le plus élevé pour former le nouveau couple alpha.
     *
     * @param maleAlpha Le lycanthrope mâle alpha.
     */
    public void newCoupleAlpha(Lycanthrope maleAlpha) {
        // Initialisation de la meilleure femelle à null
        Lycanthrope bestFemale = null;

        // Parcours de la liste des lycanthropes
        for (Lycanthrope lycanthrope : lycanthropes) {
            // Vérification si le lycanthrope est une femelle
            if (lycanthrope.getSexe().equals(Gender.FEMALE)) {
                // Si aucune meilleure femelle n'a été trouvée jusqu'à présent, la femelle actuelle devient la meilleure femelle
                if (bestFemale == null) bestFemale = lycanthrope;
                // Si le niveau de la femelle actuelle est supérieur à celui de la meilleure femelle, la femelle actuelle devient la meilleure femelle
                if (lycanthrope.getLevel() > bestFemale.getLevel()) {
                    bestFemale = lycanthrope;
                }
            }
        }
        // Création du nouveau couple alpha avec le mâle alpha et la meilleure femelle
        setCouple(new CoupleAlpha(maleAlpha, bestFemale));
    }

    /**
     * Cette méthode est utilisée pour obtenir une représentation sous forme de chaîne de tous les lycanthropes de la meute.
     * Elle parcourt la liste des lycanthropes et ajoute chaque lycanthrope (en utilisant sa méthode toString) à un StringBuilder.
     * Chaque lycanthrope est suivi d'un caractère de nouvelle ligne.
     * La méthode renvoie la représentation sous forme de chaîne du StringBuilder.
     *
     * @return Une représentation sous forme de chaîne de tous les lycanthropes de la meute.
     */
    public String getLycanthropesToString() {
        StringBuilder sb = new StringBuilder();
        for (Lycanthrope lycanthrope : lycanthropes) {
            sb.append(lycanthrope).append("\n");
        }
        return sb.toString();
    }

    /**
     * Cette méthode est utilisée pour afficher une représentation sous forme de chaîne de tous les lycanthropes de la meute.
     * Elle appelle la méthode getLycanthropesToString et imprime la chaîne retournée à la console.
     */
    public void displayLycanthropesToString() {
        System.out.println(getLycanthropesToString());
    }

    /**
     * Cette méthode est utilisée pour trier les lycanthropes de la meute par leur rang.
     * Elle utilise la méthode sort de l'interface List et un Comparator qui compare les rangs des lycanthropes.
     */
    public void sortByRank() {
        this.lycanthropes.sort(Comparator.comparingInt(Lycanthrope::getRank));
    }

    /**
     * Cette méthode est utilisée pour afficher la hiérarchie de la meute.
     * Elle commence par trier les lycanthropes par leur rang.
     * Ensuite, elle imprime le nom de la meute et une liste des lycanthropes.
     * Chaque lycanthrope est affiché avec son index dans la liste, son nom et son rang.
     */
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

    /**
     * Cette méthode est utilisée pour obtenir une représentation sous forme de chaîne de la meute.
     * Elle renvoie une chaîne qui contient le nom de la meute, le couple dominant, le nombre de lycanthropes dans la meute et une liste de tous les lycanthropes.
     * La liste des lycanthropes est obtenue en appelant la méthode getLycanthropesToString.
     *
     * @return Une représentation sous forme de chaîne de la meute.
     */
    @Override
    public String toString() {
        return "<-/ " + this.packName + " \\->\n" +
                "Couple dominant: " + this.couple +
                "\nNombre de lycanthropes: " + lycanthropes.size() +
                "\nListe des lycanthropes: \n" +
                getLycanthropesToString();
    }
}
