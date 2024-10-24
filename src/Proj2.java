import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/***
 * @file: Proj2.java
 * @description: This code takes various number of Movies and compares the runtimes and run rates for AVLs and BSTs
 * @author: Douglas Otton
 * @date: October 23, 2024
 ***/

public class Proj2 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

    // FINISH ME

        String[] myMovies = new String[10]; // Array to store movie attributes read from the CSV
        Movies movie;
        String title;
        Integer year = 0;
        String distributor;
        Long budget = 0L;
        Long domOpen = 0L;
        Long domSales = 0L;
        Long intSales = 0L;
        Long wwSales = 0L;
        String runtime;
        String license;

        ArrayList<Movies> data = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {
            String line = inputFileNameScanner.nextLine();
            if (line == null || line.isEmpty()) {
                continue; // Skip empty lines
            } else {
                line = line.trim();
            }
            myMovies = line.split(",");
            if (myMovies.length != 10) {
                continue; // Skip lines that don't have all 10 attributes
            }
            try {
                // Set the movie attributes
                title = myMovies[0] == null ? "N/A" : myMovies[0];
                if (isNumeric(myMovies[1])) {year = Integer.parseInt(myMovies[1] == null ? "0" : myMovies[1]);}
                distributor = myMovies[2] == null ? "N/A" : myMovies[2];
                if (isNumeric(myMovies[3])) {budget = Long.parseLong(myMovies[3] == null ? "0" : myMovies[3]);}
                if (isNumeric(myMovies[4])) {domOpen = Long.parseLong(myMovies[4] == null ? "0" : myMovies[4]);}
                if (isNumeric(myMovies[5])) {domSales = Long.parseLong(myMovies[5] == null ? "0" : myMovies[5]);}
                if (isNumeric(myMovies[6])) {intSales = Long.parseLong(myMovies[6] == null ? "0" : myMovies[6]);}
                if (isNumeric(myMovies[7])) {wwSales = Long.parseLong(myMovies[7] == null ? "0" : myMovies[7]);}
                runtime = myMovies[8] == null ? "0" : myMovies[8];
                license = myMovies[9] == null ? "0" : myMovies[9];

                // Create and set values for the movie object
                movie = new Movies();
                movie.setTitle(title);
                movie.setYear(year);
                movie.setDistributor(distributor);
                movie.setBudget(budget);
                movie.setDomOpen(domOpen);
                movie.setDomSales(domSales);
                movie.setIntSales(intSales);
                movie.setWwSales(wwSales);
                movie.setRuntime(runtime);
                movie.setLicense(license);

                data.add(movie);
            } catch (NumberFormatException e) {
                break;
            }
        }
        inputFileNameScanner.close();

        long startSorted, endSorted, runTimeSorted, startShuffled, endShuffled, runTimeShuffled;
        double runTimeSecondsSorted, runTimeSecondsShuffled;

        String content;
        //clearFile();

        content = "Runtime for " + numLines + " nodes (i.e., movies):\n";
        writeToFile(content);

        // BST Sorted Insertion
        BST<Movies> bstSorted = new BST<>();
        startSorted = System.nanoTime();
        for (Movies m : data) {
            bstSorted.insert(m);
        }

        endSorted = System.nanoTime();
        runTimeSorted = endSorted - startSorted;
        runTimeSecondsSorted = runTimeSorted / 1_000_000_000.0;

        content = "BST Runtimes:\nSorted BST Insertion Runtime: " + runTimeSecondsSorted + " seconds";
        System.out.println(content);
        writeToFile(content);

        // BST Sorted Search
        startSorted = System.nanoTime();
        for (Movies m : data) {
            bstSorted.find(m);
        }

        endSorted = System.nanoTime();
        runTimeSorted = endSorted - startSorted;
        runTimeSecondsSorted = runTimeSorted / 1_000_000_000.0;

        content = "Sorted BST Search Runtime: " +runTimeSecondsSorted + " seconds";
        System.out.println(content);
        writeToFile(content);

        // Shuffled BST Insertion
        Collections.shuffle(data);

        BST<Movies> bstShuffled = new BST<>();
        startShuffled = System.nanoTime();
        for (Movies m : data) {
            bstShuffled.insert(m);
        }

        endShuffled = System.nanoTime();
        runTimeShuffled = endShuffled - startShuffled;
        runTimeSecondsShuffled = runTimeShuffled / 1_000_000_000.0;

        content = "Shuffled BST Insertion Runtime: " + runTimeSecondsShuffled + " seconds";
        System.out.println(content);
        writeToFile(content);

        // Shuffled BST Search
        startShuffled = System.nanoTime();
        for (Movies m : data) {
            bstShuffled.insert(m);
        }

        endShuffled = System.nanoTime();
        runTimeShuffled = endShuffled - startShuffled;
        runTimeSecondsShuffled = runTimeShuffled / 1_000_000_000.0;

        content = "Shuffled BST Search Runtime: " + runTimeSecondsShuffled + " seconds";
        System.out.println(content);
        writeToFile(content);

        Collections.sort(data);

        // AVL Sorted Insertion
        AvlTree<Movies> avlSorted = new AvlTree<>();
        startSorted = System.nanoTime();
        for (Movies m : data) {
            avlSorted.insert(m);
        }

        endSorted = System.nanoTime();
        runTimeSorted = endSorted - startSorted;
        runTimeSecondsSorted = runTimeSorted / 1_000_000_000.0;

        content = "\nAVL Runtimes:\nSorted AVL Insertion Runtime: " + runTimeSecondsSorted + " seconds";
        System.out.println(content);
        writeToFile(content);

        // AVL Sorted Search
        startSorted = System.nanoTime();
        for (Movies m : data) {
            avlSorted.contains(m);
        }

        endSorted = System.nanoTime();
        runTimeSorted = endSorted - startSorted;
        runTimeSecondsSorted = runTimeSorted / 1_000_000_000.0;

        content = "Sorted AVL Search Runtime: " +runTimeSecondsSorted + " seconds";
        System.out.println(content);
        writeToFile(content);

        // Shuffled AVL Insertion
        Collections.shuffle(data);

        AvlTree<Movies> avlShuffled = new AvlTree<>();
        startShuffled = System.nanoTime();
        for (Movies m : data) {
            avlShuffled.insert(m);
        }

        endShuffled = System.nanoTime();
        runTimeShuffled = endShuffled - startShuffled;
        runTimeSecondsShuffled = runTimeShuffled / 1_000_000_000.0;


        content = "Shuffled AVL Insertion Runtime: " + runTimeSecondsShuffled + " seconds";
        System.out.println(content);
        writeToFile(content);

        // Shuffled AVL Search
        startShuffled = System.nanoTime();
        for (Movies m : data) {
            avlShuffled.contains(m);
        }

        endShuffled = System.nanoTime();
        runTimeShuffled = endShuffled - startShuffled;
        runTimeSecondsShuffled = runTimeShuffled / 1_000_000_000.0;

        content = "Shuffled AVL Search Runtime: " + runTimeSecondsShuffled + " seconds\n";
        System.out.println(content);
        writeToFile(content);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    private static void writeToFile(String content) {//, String filePath) {
        String filePath = "./output.txt";
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(content + System.lineSeparator());
        } catch (IOException e) {
            System.exit(1);
        }
    }

    private static void clearFile() {
        try (FileWriter fw = new FileWriter("./output.txt", false)) {
            fw.write("");
        } catch (IOException e) {
            System.exit(1);
        }
    }
}