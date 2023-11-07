package net.zoofantastique.controller.creature;

public enum Age {
    BABY("Bébé"),
    CHILD("Enfant"),
    ADULT("Adulte"),
    OLD("Vieux"),
    DEAD("Mort");

    private final String value;

    private Age(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public Age nextAge() {
        Age[] ages = Age.values();
        int currentIndex = this.ordinal();
        if (currentIndex < ages.length - 1) {
            return ages[currentIndex + 1];
        } else {
            return this;
        }
    }
}
