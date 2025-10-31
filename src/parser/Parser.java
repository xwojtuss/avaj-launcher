package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;
import simulation.Simulation;

public class Parser {
    public Parser(String path, Simulation sim) throws FileNotFoundException, ParseException {
        if (path.length() == 0) throw new FileNotFoundException();
        File    scenario = new File(path);
        Scanner reader = new Scanner(scenario);
        int    lineNum = 1;

        if (!reader.hasNextLong()) {
            reader.close();
            throw new ParseException("Simulation iteration count required", lineNum);
        }
        long    iterCount = reader.nextLong();
        if (iterCount < 1) {
            reader.close();
            throw new ParseException("Simulation interation count must be a positive integer", lineNum);
        }
        if (!reader.hasNextLine()) {
            reader.close();
            throw new ParseException("Expected at least two lines", lineNum);
        }
        if (reader.nextLine() != "") {
            reader.close();
            throw new ParseException("Simulation interation count must be a positive integer", lineNum);
        };
        sim.setIterCount(iterCount);
        while (reader.hasNextLine()) {
            lineNum++;
            String      line = reader.nextLine();
            String[]    words = line.split("\\s+");
            if (words.length != 5) {
                reader.close();
                throw new ParseException("Invalid format, expected: TYPE NAME LONGITUDE LATITUDE HEIGHT", lineNum);
            }
        }
        reader.close();
    }
}