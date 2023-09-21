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

        HashMap<String, ArrayList<Integer>> movieAndReviews = new HashMap<>();

        try (is) {
            Scanner scan = new Scanner(is);
            int reviews = scan.nextInt();
            scan.nextLine();

            String name = null;
            for (int i = 0; i < reviews*2; i++) {
                if (i % 2 == 0) {
                    name = scan.nextLine();
                } else {
                    int score = scan.nextInt();
                    movieAndReviews.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
                    if (i != reviews*2-1) {
                        scan.nextLine();
                    }
                }
            }
        }

        movieAndReviews.forEach((String filmNavn, ArrayList<Integer> karaktere) -> {
            float[] sum = new float[1];

            karaktere.forEach((score) -> sum[0] += score);
            System.out.println(filmNavn + ": " + karaktere.size() + ", gennemsnittet: " + (sum[0] / karaktere.size()));
        });
    }
}
