package net.zoofantastique.controller.utils;

import java.util.Random;

/**
 * Classe Utils qui représente une classe utilitaire.
 * Cette classe contient des méthodes utilitaires.
 */
public class Utils {
    public static double getRandomInRange(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
