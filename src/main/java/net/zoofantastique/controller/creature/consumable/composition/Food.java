package net.zoofantastique.controller.creature.consumable.composition;

import net.zoofantastique.controller.creature.consumable.behavior.FoodType;

public abstract class Food {
    // Attributs
    // Nom de l'aliment
    String name;
    // Valeur nutritionel
    int value;
    // Description de l'aliment
    String desc;
    // Type de l'aliment
    FoodType foodType;

    // Getter et Setter
    /**
     * getter du nom de l'aliment
     *
     * @author Angelo P.
     * @return nom de l'aliment
     */
    public String getName() {
        return name;
    }

    /**
     * setter du nom de l'aliment
     *
     * @author Angelo P.
     * @param name nom de l'aliment
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter de la valeur nutritionel de l'aliment
     *
     * @author Angelo P.
     * @return valeur nutritionel de l'aliment
     */
    public int getValue() {
        return value;
    }

    /**
     * setter du la valeur nutritionel de l'aliment
     *
     * @author Angelo P.
     * @param value valeur nutritionel de l'aliment
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * getter du type de nourriture
     *
     * @author Angelo P.
     * @return objet FoodType définissant le type d'aliment
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     * getter de la valeur d'affichage du type d'aliment
     *
     * @author Angelo P.
     * @return la valeur d'affichage du type d'aliment
     */
    public String getFoodTypeValue() {
        return foodType.getValue();
    }

    /**
     * setter du type de nourriture
     *
     * @author Angelo P.
     * @param foodType type de l'aliment
     */
    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    /**
     * getter de la description de l'aliment
     *
     * @author Angelo P.
     * @return description de l'aliment
     */
    public String getDesc() {
        return desc;
    }

    /**
     * setter de la description de l'aliment
     *
     * @author Angelo P.
     * @param desc description de l'aliment
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "<-/ " + getClass().getSimpleName() + " \\->" +
               "\n--------------\n" +
               "Nom: " + name + "\n" +
               "Valeur: " + value + "\n" +
               "Type: " + foodType.getValue() + "\n" +
               "Description: " + desc;
    }
}
