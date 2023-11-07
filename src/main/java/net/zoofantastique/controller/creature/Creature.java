package net.zoofantastique.controller.creature;

public class Creature {
    private String name;
    private String sexe;
    private float wight;
    private float height;
    private Age age;
    private int hunger;
    private boolean isSleeping;
    private boolean isSick;

    public Creature() {
        age = Age.BABY;
    }

    public String getAge() {
        return age.getValue();
    }

    public void addAge() {
        this.age = age.nextAge();
    }
}
