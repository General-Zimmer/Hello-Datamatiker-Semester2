package exercise5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Opg5 {
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("reviews1");

        if (is == null) {
            throw new FileNotFoundException("File not found");
        }

        HashMap<String, ArrayList<Integer>> movieCounts = new HashMap<>();

        try (is) {
            Scanner scan = new Scanner(is);
            int reviews = scan.nextInt();
            scan.nextLine();

            String name = null;
            for (int i = 0; i < reviews*2; i++) {
                if (i % 2 == 0 && scan.hasNextLine()) {
                    name = scan.nextLine();
                } else {
                    int score = scan.nextInt();
                    movieCounts.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
                    if (scan.hasNextLine())
                        scan.nextLine();
                }

            }
        }

        movieCounts.forEach((key, value) -> {
            float[] sum = new float[1];

            value.forEach((score) -> sum[0] += score);
            System.out.println(key + ": " + value.size() + ", gennemsnittet: " + (sum[0] / value.size()));
        });
    }
}
