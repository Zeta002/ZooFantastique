package net.zoofantastique.controller.consumable.composition;

import net.zoofantastique.controller.consumable.behavior.FoodType;

public abstract class Food {
    // Attributs
    private String name; // Le nom de la nourriture.
    private int value; // La valeur nutritionnelle de la nourriture.
    private String desc; // La description de la nourriture.
    private FoodType foodType; // Le type de nourriture.

    // Constructeur
    public Food(String name, int value, FoodType foodType) {
        this.name = name;
        this.value = value;
        this.foodType = foodType;
    }

    // Getter et Setter

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public FoodType getFoodType() {
        return foodType;
    }
    public String getFoodTypeValue() {
        return foodType.getValue();
    }
    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la nourriture.
     * Construit une chaîne de caractères contenant le nom, la valeur nutritionnelle, le type et la description de la nourriture.
     *
     * @return Une chaîne de caractères représentant la nourriture.
     */
    @Override
    public String toString() {
        return "<-/ " + name + " \\->\n" +
                "--------------" +
                "\nValeur: " + value +
                "\nType: " + foodType.getValue() +
                "\nDescription: " + desc +
                "\n";
    }
}
