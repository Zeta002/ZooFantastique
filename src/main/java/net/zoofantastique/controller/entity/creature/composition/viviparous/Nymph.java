package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.utils.Utils;

import java.util.Random;

/**
 * Classe Nymph qui représente une nymphe dans un zoo.
 * Une nymphe est une créature vivipare.
 * Cette classe étend la classe Viviparous.
 */
public class Nymph extends Creature implements Viviparous {
    public Nymph(String name, Gender sexe) {
        super(name, sexe, "ahahah");
        setAgeScale(60);
        setDimHunger(55);
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
    public Nymph giveBirth() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Nymph(getName(), babySexe);
    }
}