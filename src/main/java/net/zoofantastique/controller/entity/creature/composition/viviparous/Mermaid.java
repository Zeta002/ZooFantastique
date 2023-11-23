package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;

import java.util.Random;

/**
 * Classe Mermaid qui représente une sirène dans un zoo.
 * Une sirène est une créature vivipare qui peut nager.
 * Cette classe étend la classe Viviparous et implémente l'interface Swimmer.
 */
public class Mermaid extends Viviparous implements Swimmer {
    public Mermaid(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "*chant mélodieux*");
    }

    /**
     * Méthode pour faire nager une Sirène.
     * Affiche un message indiquant que la Sirène nage, en précisant le nom de la Sirène.
     */
    @Override
    public void swim() {
        System.out.println(super.getName() + " *nage*");
    }

    /**
     * Méthode pour faire naître un bébé Sirène.
     * Cette méthode génère une nouvelle Sirène avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Une nouvelle Sirène qui vient de naître.
     */
    @Override
    public Viviparous giveBirth(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;
        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Mermaid(getName(), babySexe, babyWeight, babyHeight);
    }
}