package tower;

import aircraft.Flyable;
import logger.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        Logger.getInstance().logRegister(p_flyable, this);
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        Logger.getInstance().logUnregister(p_flyable, this);
    }

    protected void  conditionChanged() {
        for (Flyable observer : new ArrayList<>(this.observers)) {
            observer.updateConditions();
        }
    }
}