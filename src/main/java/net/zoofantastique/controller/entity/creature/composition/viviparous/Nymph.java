package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;

import java.util.Random;

/**
 * Classe Nymph qui représente une nymphe dans un zoo.
 * Une nymphe est une créature vivipare.
 * Cette classe étend la classe Viviparous.
 */
public class Nymph extends Viviparous {
    public Nymph(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "ahahah");
    }

    /**
     * Méthode pour faire naître un bébé Nymphe.
     * Cette méthode génère une nouvelle Nymphe avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Une nouvelle Nymphe qui vient de naître.
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

        return new Nymph(getName(), babySexe, babyWeight, babyHeight);
    }
}