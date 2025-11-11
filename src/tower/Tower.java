package tower;

import aircraft.Flyable;
import logger.Logger;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        // System.out.println(this.getClass().getSimpleName());
        Logger.getInstance().logRegister(p_flyable, this);
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