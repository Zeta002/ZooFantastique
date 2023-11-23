package net.zoofantastique.controller.consumable.composition;

import net.zoofantastique.controller.consumable.behavior.FoodType;

public abstract class Food {
    // Attributs
    // Le nom de la nourriture.
    private String name;
    // La valeur nutritionnelle de la nourriture.
    private int value;
    // La description de la nourriture.
    private String desc;
    // Le type de la nourriture, défini par l'énumération FoodType.
    private FoodType foodType;



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
        StringBuilder sb = new StringBuilder("<-/ " + name + " \\->\n");
        sb.append("--------------")
                .append("\nValeur: ").append(value)
                .append("\nType: ").append(foodType.getValue())
                .append("\nDescription: ").append(desc)
                .append("\n");
        return sb.toString();
    }
}
