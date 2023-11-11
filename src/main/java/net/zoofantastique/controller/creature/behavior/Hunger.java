package net.zoofantastique.controller.creature.behavior;

public enum Hunger {
    SATISFIED("Répu",10),
    HUNGRY("Affamé(e)", 3);

    // Attributs
    private String state;
    private int hunger;

    // Constructeur
    Hunger(String state, int hunger) {
        this.state = state;
        this.hunger = hunger;
    }

    public String getState() {
        return state;
    }

    public void setHunger(int hunger) {
        if (hunger < HUNGRY.hunger) {
            this.state = HUNGRY.state;
        }
        this.state = SATISFIED.state;
        // TODO corriger la methode
    }
}
