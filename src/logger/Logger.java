package logger;

import java.io.FileWriter;
import java.io.IOException;
import aircraft.Flyable;
import tower.Tower;

public class Logger {
    private static Logger   instance;
    private FileWriter      output = null;

    private Logger() {
        try {
            this.output = new FileWriter("simulation.txt");
        } catch (IOException e) {
            this.output = null;
        }
    }

    public static Logger   getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private static String   camelToSnakeSpace(String s) {
        return s
            .replaceAll("([A-Z])(?=[A-Z])", "$1 ")
            .replaceAll("([a-z])([A-Z])", "$1 $2")
            .toLowerCase();
    }

    public void logRegister(Flyable p_flyable, Tower p_tower) {
        if (instance.output == null) return;

        try {
            instance.output.write("Tower says: " + p_flyable + " registered to " + camelToSnakeSpace(p_tower.getClass().getSimpleName()) + ".\n");
        } catch (Exception e) {}
    }

    public void logUnregister(Flyable p_flyable, Tower p_tower) {
        if (instance.output == null) return;

        try {
            instance.output.write("Tower says: " + p_flyable + " unregistered from " + camelToSnakeSpace(p_tower.getClass().getSimpleName()) + ".\n");
        } catch (Exception e) {}
    }

    public void logWeatherChange(Flyable p_flyable, String message) {
        if (instance.output == null) return;

        try {
            instance.output.write(p_flyable + ": " + message + "\n");
        } catch (Exception e) {}
    }

    public void end() {
        if (instance.output == null) return;
        try {
            instance.output.close();
            instance.output = null;
        } catch (Exception e) {}
    }
}