package simulation;

import parser.Parser;
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
        Simulation sim = new Simulation();
        try {
            Parser parser = new Parser(args[0], sim);
        } catch (Exception e) {
            errorExit(e.getMessage());
        }
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