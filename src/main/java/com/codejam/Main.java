package com.codejam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Input file needs to be specified");
            System.exit(-1);
        }
        List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        String firstLine = lines.get(0);
        int numberOfBoards;
        try {
            numberOfBoards = Integer.parseInt(lines.get(0));
            lines.remove(0);
        } catch (NumberFormatException nfe) {
            System.err.println("Unexpected input, expected first line to be a number was " + firstLine);
            return;
        }
        if (lines.size() / 5 != numberOfBoards) {
            System.err.println("Unexpected number of rows, expected " + (numberOfBoards*5) + " got " + (lines.size() + 1));
            return;
        }
        Iterator<String> linesIterator = lines.iterator();
        TTTTChecker ttttClassifier = new TTTTChecker();
        for(int i = 1; i <= numberOfBoards; i++) {
            List<String> input = new LinkedList<>();
            input.add(linesIterator.next());
            input.add(linesIterator.next());
            input.add(linesIterator.next());
            input.add(linesIterator.next());
            System.out.print("Case #" + i + ": ");
            try {
                System.out.print(ttttClassifier.check(input));
            } catch (IllegalArgumentException iae) {
                System.err.println("Warning: " + iae.getMessage());
            }
            System.out.print("\n");

            //Skip the empty line
            linesIterator.next();
        }

    }
}
