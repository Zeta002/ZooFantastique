package net.zoofantastique.controller.creature.behavior;

public enum Age {
    BABY("Bébé"),
    CHILD("Enfant"),
    ADULT("Adulte"),
    OLD("Vieux"),
    DEAD("Mort");

    // Attributs
    private final String value;

    // Constructeur
    Age(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * methode permettant d'augmenter l'age de 1, si l'age
     * est à l'état de mort, alors il ne s'augmente plus
     *
     * @author Quentin B.
     * @return objet enum Age dont l'age est augmenter de 1
     */
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
