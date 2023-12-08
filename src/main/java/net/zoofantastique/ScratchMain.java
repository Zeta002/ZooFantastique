package net.zoofantastique;

import net.zoofantastique.view.Game;

public class ScratchMain {
    public static void main(String[] args) {
//        Pack p = new Pack("meute de test", new Pair<>(new Lycanthrope("Le male", Gender.MALE, 2, 2), new Lycanthrope("La femelle", Gender.FEMALE, 2, 2)));
//        System.out.println(p);
        Game game = new Game();
        game.start();

    }
}
