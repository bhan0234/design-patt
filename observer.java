import java.util.*;

// Subject interface defines the methods for managing and notifying observers
interface Subject {
    void addSubscriber(Observer observer); // Add an observer (subscriber)
    void removeSubscriber(Observer observer); // Remove an observer (subscriber)
    void notifySubscribers(); // Notify all observers about the update
}

// Observer interface defines the method to be implemented by all subscribers
interface Observer {
    void update(float temperature); // Update method to receive notifications
}

// Concrete implementation of the Subject
class Station implements Subject {
    private float temperature; // Holds the current temperature
    private List<Observer> observers = new ArrayList<>(); // List to store observers (subscribers)

    // Add an observer to the list
    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer from the list
    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers about the temperature update
    @Override
    public void notifySubscribers() {
        for (Observer obs : observers) {
            obs.update(temperature); // Call the update method of each observer
        }
    }

    // Set a new temperature and notify all subscribers
    public void setTemperature(float temperature) {
        this.temperature = temperature; // Update the temperature
        notifySubscribers(); // Notify subscribers about the change
    }
}

// Concrete implementation of the Observer interface
class subsriber implements Observer {
    private String name; // Name of the subscriber

    // Constructor to initialize the subscriber's name
    subsriber(String name) {
        this.name = name;
    }

    // Update method to receive notifications from the Subject
    @Override
    public void update(float temperature) {
        System.out.println(name + temperature); // Display the received temperature
    }
}

// Main class to demonstrate the Observer Pattern
public class Main {
    public static void main(String[] args) {
        // Create a Subject (Station)
        Station weatherStation = new Station();

        // Create Subscribers (Observers)
        Observer subscriber1 = new subsriber("Subscriber1: ");
        Observer subscriber2 = new subsriber("Subscriber2: ");
        Observer subscriber3 = new subsriber("Subscriber3: ");

        // Register subscribers to the station
        weatherStation.addSubscriber(subscriber1);
        weatherStation.addSubscriber(subscriber2);
        weatherStation.addSubscriber(subscriber3);

        // Update temperature and notify subscribers
        System.out.println("Temperature changes to 25°C:");
        weatherStation.setTemperature(25);

        // Update temperature and notify subscribers
        System.out.println("\nTemperature changes to 30°C:");
        weatherStation.setTemperature(30);

        // Unsubscribe one subscriber
        System.out.println("\nUnsubscribing Subscriber2...");
        weatherStation.removeSubscriber(subscriber2);

        // Update temperature again and notify remaining subscribers
        System.out.println("\nTemperature changes to 20°C:");
        weatherStation.setTemperature(20);
    }
}
