package opgaver.util;

public class Util {
    public static void wasteTime(double max) {
        wasteTime(max, 3);
    }

    public static void wasteTime(double size, int loopAmount) {
        double amount = size * Math.random();
        loopAmount--;

        // Can slowly increase the size of loops
        for (int i = 0; i < amount; i++)
            size = 10+(size * (Math.random()+0.5));

        if (loopAmount >= 0)
            wasteTime(size, loopAmount);
    }
}
