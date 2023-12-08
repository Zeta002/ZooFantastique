package net.zoofantastique.controller.entity;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Gender;

/**
 * Classe abstraite Alive représentant une entité vivante.
 * Une entité vivante a une espèce, un nom, un sexe et un âge.
 */
public abstract class Alive {
    private final String species = getClass().getSimpleName(); // L'espèce de la créature
    String name; // Le nom de la créature
    Gender sexe; // Le sexe de la créature
    Age age; // L'âge de la créature

    // Constructeur
    public Alive(String name, Gender sexe, Age age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
    }

    // Méthodes

    /**
     * Méthode pour faire vieillir une créature.
     * Cette méthode met à jour l'âge de la créature à l'âge suivant dans l'énumération Age.
     */
    public void aging() {
        age = age.nextAge();
    }

    // Getter et setter

    public Age getAge() {
        return age;
    }
    public String getAgeState() {
        return this.age.getValue();
    }
    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Gender getSexe() {
        return this.sexe.getSexe();
    }
    public String getSexeStatus() {
        return this.sexe.getSexeStatus();
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature.
     * Construit une chaîne de caractères contenant l'espèce, le nom, le sexe et l'âge de la créature.
     *
     * @return Une chaîne de caractères représentant la créature.
     */
    @Override
    public String toString() {
        return "<-/ " + species + " \\->\n" +
                "--------------" +
                "\nNom: " + name +
                "\nSexe: " + sexe.getSexeStatus() +
                "\nAge: " + age.getValue();
    }
}
