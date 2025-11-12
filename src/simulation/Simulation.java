package simulation;

import parser.Parser;
import logger.Logger;
import tower.WeatherTower;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulation {
    private static long iterCount = 0;

    public Simulation() {}

    public static void main(String[] args) {
        if (args.length != 1) errorExit("Provide one file name to read");
        Simulation      sim = new Simulation();
        WeatherTower    tower = new WeatherTower();
        try {
            Parser parser = new Parser(args[0], sim, tower);
        } catch (ParseException e) {
            errorExit("Error on line " + e.getErrorOffset() + ":\n\t" + e.getMessage());
        } catch (Exception e) {
            errorExit(e.getMessage());
        }
        while (iterCount-- > 0) {
            tower.changeWeather();
        }
        Logger.getInstance().end();
    }

    static void errorExit(String message) {
        System.out.println(message);
        System.exit(1);
    }

    public static void  setIterCount(long p_iterCount) {
        iterCount = p_iterCount;
    }

    public static long  getIterCount() {
        return iterCount;
    }
}