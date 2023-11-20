package net.zoofantastique.controller.creature.composition;

import net.zoofantastique.controller.creature.behavior.Age;
import net.zoofantastique.controller.creature.behavior.Flying;
import net.zoofantastique.controller.creature.behavior.Gender;
import net.zoofantastique.controller.creature.behavior.Rebirth;
import net.zoofantastique.controller.creature.oviparous.Oviparous;

public class Phoenix extends Oviparous implements Flying, Rebirth {
    public Phoenix(String name, Gender sexe, double weight, double height) {
        super(name, sexe, weight, height, "coua coua");
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " *est entrain de voler*");
    }

    @Override
    public void aging() {
        super.aging();
        rebirth();
    }

    @Override
    public void setAge(Age age) {
        super.setAge(age);
        rebirth();
    }

    @Override
    public void rebirth() {
        if (getAge() == Age.DEAD) {
            setAge(Age.BABY);
        }
    }

    @Ovveride
    public Oviparous eggsHatch(){
        Random random = new Random();
        double babyWeight = 2.5 + (4.3 - 2.5) * random.nextDouble();
        double babyHeight = 0.45 + (0.55 - 0.45) * random.nextDouble();

        if (random.nextInt(2)) {
            Gender babySexe = Gender.FEMALE;
        }
        else {
            Gender babySexe = Gender.MALE;
        }
        return new Phoenix(getName(), babySexe, babyWeight, babyHeight, getShout());
    }
}