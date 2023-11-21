package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Gender;

/**
 * Classe abstraite Alive représentant une entité vivante.
 * Une entité vivante a une espèce, un nom, un sexe et un âge.
 */
public abstract class Alive {
    // L'espèce de la créature, déterminée par le nom de la classe qui l'étend
    private final String species = getClass().getSimpleName();
    // Le nom de la créature
    String name;
    // Le sexe de la créature, peut être Male ou Femelle
    Gender sexe;
    // L'âge de la créature
    Age age;

    /**
     * Constructeur de la classe Alive avec nom, sexe et âge.
     *
     * @param name le nom de la créature.
     * @param sexe le sexe de la créature, peut être Male ou Femelle.
     * @param age  l'âge de la créature.
     */
    public Alive(String name, Gender sexe, Age age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la créature.
     * Construit une chaîne de caractères contenant l'espèce, le nom, le sexe et l'âge de la créature.
     *
     * @return Une chaîne de caractères représentant la créature.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<-/ " + species + " \\->\n");
        sb.append("--------------")
                .append("\nNom: ").append(name)
                .append("\nSexe: ").append(sexe.getSexeStatus())
                .append("\nAge: ").append(age.getValue());
        return sb.toString();
    }
}
