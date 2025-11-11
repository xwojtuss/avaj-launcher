package simulation;

import parser.Parser;
import logger.Logger;
import tower.WeatherTower;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulation {
    private long    iterCount;

    public Simulation() {
        this.iterCount = 0;
    }

    public static void main(String[] args) {
        if (args.length != 1) errorExit("Provide one file name to read");
        Simulation      sim = new Simulation();
        WeatherTower    tower = new WeatherTower();
        try {
            Parser parser = new Parser(args[0], sim, tower);
        } catch (Exception e) {
            errorExit(e.getMessage());
        }
        Logger.getInstance().end();
    }

    static void errorExit(String message) {
        System.out.println(message);
        System.exit(1);
    }

    public void setIterCount(long iterCount) {
        this.iterCount = iterCount;
    }

    public long getIterCount() {
        return this.iterCount;
    }
}