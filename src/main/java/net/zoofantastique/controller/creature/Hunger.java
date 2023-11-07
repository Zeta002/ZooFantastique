package net.zoofantastique.controller.creature;

public enum Hunger {
    SATISFIED("Répu",10),
    HUNGRY("Affamé(e)", 3);

    private String state;
    private int hunger;

    private Hunger(String state, int hunger) {
        this.state = state;
        this.hunger = hunger;
    }

    public String getState() {
        return state;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger < HUNGRY.hunger) {
            this.state = HUNGRY.state;
        }
        this.state = SATISFIED.state;
    }
}
