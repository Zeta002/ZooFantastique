package net.zoofantastique.controller.entity.creature.composition.oviparous;

import net.zoofantastique.controller.entity.creature.behavior.Age;
import net.zoofantastique.controller.entity.creature.behavior.Flying;
import net.zoofantastique.controller.entity.creature.behavior.Gender;
import net.zoofantastique.controller.entity.creature.behavior.Rebirth;
import net.zoofantastique.controller.entity.creature.composition.Creature;
import net.zoofantastique.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe Phoenix qui représente un phoenix dans un zoo.
 * Un phoenix est une créature ovipare qui peut voler et renaître.
 * Cette classe étend la classe Creature et implémente les interfaces Oviparous, Flying et Rebirth.
 */
public class Phoenix extends Creature implements Oviparous, Flying, Rebirth {
    public Phoenix(String name, Gender sexe) {
        super(name, sexe, "coua coua");
        setMinHeight(new ArrayList<>(List.of(0.1, 0.3, 0.7, 1.2, 1.4)));
        setMaxHeight(new ArrayList<>(List.of(0.2, 0.5, 1.0, 1.5, 1.7)));
        setMinWeight(new ArrayList<>(List.of(2.0, 5.0, 9.0, 11.0, 13.0)));
        setMaxWeight(new ArrayList<>(List.of(3.5, 8.0, 13.0, 15.0, 16.0)));

        updateAndRestart(200, 90);

        calcSizeAndWeight();
    }

    /**
     * Méthode pour faire voler un Phoenix.
     * Affiche un message indiquant que le Phoenix vole, en précisant le nom du Phoenix.
     */
    @Override
    public void fly() {
        System.out.println(super.getName() + " *est entrain de voler*");
    }

    /**
     * Méthode pour faire vieillir un Phoenix.
     * Cette méthode met à jour l'âge du Phoenix à l'âge suivant dans l'énumération Age, puis appelle la méthode rebirth pour vérifier si le Phoenix doit renaître.
     */
    @Override
    public void aging() {
        super.aging();
        rebirth();
    }

    /**
     * Méthode pour définir l'âge d'un Phoenix.
     * Cette méthode met à jour l'âge du Phoenix et appelle ensuite la méthode rebirth pour vérifier si le Phoenix doit renaître.
     *
     * @param age Le nouvel âge du Phoenix.
     */
    @Override
    public void setAge(Age age) {
        super.setAge(age);
        rebirth();
    }

    /**
     * Méthode pour faire renaître un Phoenix.
     * Si l'âge du Phoenix est DEAD (mort), son âge est réinitialisé à BABY (bébé).
     */
    @Override
    public void rebirth() {
        if (getAge() == Age.DEAD) {
            setAge(Age.BABY);
        }
    }

    /**
     * Méthode pour faire éclore les œufs d'un Phoenix.
     * Cette méthode génère un nouveau Phoenix avec un sexe, un poids et une taille aléatoires.
     * Le sexe est déterminé de manière aléatoire, avec une probabilité égale d'être mâle ou femelle.
     * Le poids et la taille sont déterminés en générant un nombre aléatoire dans un intervalle spécifique.
     *
     * @return Un nouveau Phoenix qui vient d'éclore.
     */
    @Override
    public Phoenix eggsHatch() {
        Random random = new Random();
        Gender babySexe = Gender.MALE;

        if (random.nextInt(2) == 1) {
            babySexe = Gender.FEMALE;
        }

        return new Phoenix(getName(), babySexe);
    }
}