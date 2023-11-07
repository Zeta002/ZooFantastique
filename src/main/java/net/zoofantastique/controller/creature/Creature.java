package net.zoofantastique.controller.creature;

public class Creature {
    private String name;
    private final String sexe;
    private double weight;
    private double height;
    private Age age;
    private Hunger hunger;
    private boolean isSleeping;
    private boolean isSick;


    public Creature(String name, String sexe, double weight, double height) {
        this.name = name;
        this.sexe = sexe;
        this.weight = weight;
        this.height = height;

        this.age = Age.BABY;
        this.isSick = false;
        this.isSleeping = false;
        this.hunger = Hunger.SATISFIED;
    }

    // Getter et Setter
    public String getAge() {
        return age.getValue();
    }

    public void addAge() {
        this.age = age.nextAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexe() {
        return sexe;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getHungerState() {
        return hunger.getState();
    }

    public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger.setHunger(hunger);
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }
}
