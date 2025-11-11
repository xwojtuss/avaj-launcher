package tower;

import aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
    }

    protected void  conditionChanged() {
        for (Flyable observer : this.observers) {
            observer.updateConditions();
        }
    }
}