package aircraft;

import tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower  weatherTower;
    public abstract void    updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        p_tower.register(this);
        System.out.println("Tower says: " + this + " registered to weather tower.");
    }
}