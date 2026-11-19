import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : List.copyOf(observers)) {
            if (deveNotificar(observer)) {
                observer.update(this);
            }
        }
    }

    protected boolean deveNotificar(Observer observer) {
        return true;
    }
}
