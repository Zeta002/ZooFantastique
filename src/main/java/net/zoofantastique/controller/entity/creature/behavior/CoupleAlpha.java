package net.zoofantastique.controller.entity.creature.behavior;

import net.zoofantastique.controller.entity.creature.composition.viviparous.Lycanthrope;

import static net.zoofantastique.view.ConsoleTricks.boldText;

// TODO : doc
public class CoupleAlpha {
    // Attributs
    private Lycanthrope first;
    private Lycanthrope second;

    // Constructeur
    public CoupleAlpha(Lycanthrope first, Lycanthrope second) {
        this.first = first;
        this.second = second;
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

    @Override
    public String toString() {
        return boldText(first.getName()) + "(" + first.getRankString() + ")" + " et "
                + boldText(second.getName()) + "(" + first.getRankString() + ")";
    }
}