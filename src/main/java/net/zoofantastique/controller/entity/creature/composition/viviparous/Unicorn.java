package net.zoofantastique.controller.entity.creature.composition.viviparous;

import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Runner;

import java.util.Random;

/**
 * Classe Unicorn qui représente une licorne dans un zoo.
 * Une licorne est une créature vivipare qui peut courir.
 * Cette classe étend la classe Viviparous et implémente l'interface Runner.
 */
public class Unicorn extends Viviparous implements Runner {
    public Unicorn(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "hihihiha");
    }

    /**
     * Méthode pour faire courir une Licorne.
     * Affiche un message indiquant que la Licorne court, en précisant le nom de la Licorne.
     */
    @Override
    public void run() {
        System.out.println(super.getName() + " *cours*");
    }

    /**
     * Méthode pour faire naître un bébé Licorne.
     * Cette méthode génère une nouvelle Licorne avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Une nouvelle Licorne qui vient de naître.
     */
    @Override
    public Viviparous giveBirth(){
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        double babyWeight = 0.5 + (0.75 - 0.5) * random.nextDouble();
        double babyHeight = 0.9 + (1.15 - 0.9) * random.nextDouble();

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Unicorn(getName(), babySexe, babyWeight, babyHeight);
    }
}