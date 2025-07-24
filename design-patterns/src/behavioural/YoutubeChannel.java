package behavioural;

import java.util.List;

public class YoutubeChannel implements Subject {
    List<Observer> subscribers = new java.util.ArrayList<>();


    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.subscribers) {
            observer.notified();
        }
    }
}
