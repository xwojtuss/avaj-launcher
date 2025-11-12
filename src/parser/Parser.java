package parser;

import java.lang.Integer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;
import simulation.Simulation;
import aircraft.AircraftFactory;
import exceptions.InvalidAircraft;
import exceptions.InvalidName;
import tower.WeatherTower;

public class Parser {
    public Parser(String path, Simulation sim, WeatherTower tower) throws FileNotFoundException, ParseException, InvalidAircraft, InvalidName {
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
            Coordinates coord;
            try {
                coord = new Coordinates(Integer.parseInt(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]));
                if (coord.getHeight() <= 0 || coord.getLatitude() <= 0 || coord.getLongitude() <= 0) throw new Exception();
            } catch (Exception e) {
                throw new ParseException("Invalid coordinate, expected a positive integer", lineNum);
            }
            AircraftFactory.getInstance().newAircraft(words[0], words[1], coord).registerTower(tower);
        }
        if (lineNum == 1) throw new ParseException("Expected at least one aircraft", lineNum);
        reader.close();
    }
}