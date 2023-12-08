package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Swimmer;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.utils.Utils;

import java.util.Random;

/**
 * Classe Mermaid qui représente une sirène dans un zoo.
 * Une sirène est une créature vivipare qui peut nager.
 * Cette classe étend la classe Viviparous et implémente l'interface Swimmer.
 */
public class Mermaid extends Creature implements Viviparous, Swimmer {
    public Mermaid(String name, Gender sexe) {
        super(name, sexe, "*chant mélodieux*");

        updateAndRestart(40, 28);

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
    public Mermaid giveBirth() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Mermaid(getName(), babySexe);
    }
}