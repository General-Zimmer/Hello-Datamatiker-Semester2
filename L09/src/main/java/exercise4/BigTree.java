package exercise4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.TreeSet;

public class BigTree {
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("Gjoengehoevdingen.txt");

        if (is == null) {
            throw new FileNotFoundException("File not found");
        }

        TreeSet<String> words = new TreeSet<>();

        try (is) {
            Scanner scan = new Scanner(is);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                line = line.toLowerCase();

                String[] unfilteredWords = line.split(" ");

                for (String word : unfilteredWords) {

                    String filteredWord = word.replace("\"", "").replace(",", "").replace(".", "");

                    words.add(filteredWord);
                }

            }
        }

        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("\n" + words.size());


    }
}
