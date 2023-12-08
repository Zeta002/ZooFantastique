package net.zoofantastique.utils;

import java.util.Random;

public class Utils {

    public static int timeControle = 1;

    public static double getRandomDoubleInRange(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    public static int getRandomIntInRange(int min, int max) {
        Random random = new Random();
        return min + (max - min) * random.nextInt();
    }

}
