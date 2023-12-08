package net.zoofantastique.controller.entity.creature.behavior;

import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;

import static net.zoofantastique.view.ConsoleTricks.boldText;

/**
 * Classe CoupleAlpha qui représente un couple alpha dans une meute.
 * Un couple alpha est composé d'un lycanthrope mâle alpha et d'un lycanthrope femelle alpha.
 */
public class CoupleAlpha {
    // Attributs
    private Lycanthrope first;
    private Lycanthrope second;

    // Constructeur
    public CoupleAlpha(Lycanthrope first, Lycanthrope second) {
        this.first = first;
        this.second = second;
        initCouple();
    }

    public void initCouple() {
        this.first.setRank(0);
        this.second.setRank(0);
    }

    // Getter & Setter

    public Lycanthrope getFirst() {
        return first;
    }
    public void setFirst(Lycanthrope first) {
        this.first = first;
    }

    public Lycanthrope getSecond() {
        return second;
    }
    public void setSecond(Lycanthrope second) {
        this.second = second;
    }

    /**
     * Cette méthode est utilisée pour obtenir une représentation sous forme de chaîne du couple alpha.
     * Elle renvoie une chaîne qui contient le nom du premier lycanthrope (mâle alpha), son rang, le mot "et",
     * le nom du second lycanthrope (femelle alpha) et son rang. Les noms des lycanthropes sont affichés en gras.
     *
     * @return Une représentation sous forme de chaîne du couple alpha.
     */
    @Override
    public String toString() {
        return boldText(first.getName()) + "(" + first.getRankString() + ")" + " et "
                + boldText(second.getName()) + "(" + first.getRankString() + ")";
    }
}