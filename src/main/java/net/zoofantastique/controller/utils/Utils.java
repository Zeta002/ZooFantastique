package net.zoofantastique.controller.utils;

import java.util.Random;

public class Utils {

    public static double getRandomInRange(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

}