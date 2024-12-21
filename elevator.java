import java.util.*;

class Elevator {
    private int currentFloor;
    private boolean isMoving;
    private int totalFloors;

    public Elevator(int totalFloors) {
        this.currentFloor = 0; // Assume elevator starts at floor 0
        this.isMoving = false;
        this.totalFloors = totalFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int floor) {
        if (floor >= 0 && floor < totalFloors) {
            System.out.println("Elevator moving from " + currentFloor + " to " + floor);
            currentFloor = floor;
        } else {
            System.out.println("Invalid floor");
        }
    }

    public void stop() {
        isMoving = false;
        System.out.println("Elevator stopped at floor " + currentFloor);
    }

    public boolean isIdle() {
        return !isMoving;
    }
}


class ElevatorSystem {
    private List<Elevator> elevators;

    public ElevatorSystem(int numberOfElevators, int totalFloors) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(totalFloors));
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        // Find an available (idle) elevator
        Elevator elevator = findAvailableElevator();
        if (elevator != null) {
            System.out.println("Request: From floor " + sourceFloor + " to " + destinationFloor);
            elevator.moveToFloor(sourceFloor);
            elevator.moveToFloor(destinationFloor);
        } else {
            System.out.println("No elevator is available at the moment.");
        }
    }

    private Elevator findAvailableElevator() {
        // Look for the first idle elevator
        for (Elevator elevator : elevators) {
            if (elevator.isIdle()) {
                return elevator;
            }
        }
        return null; // If no elevator is idle
    }
}


public class Main {
    public static void main(String[] args) {
        // Create an elevator system with 3 elevators and 10 floors
        ElevatorSystem elevatorSystem = new ElevatorSystem(3, 10);

        // Simulate requests
        elevatorSystem.requestElevator(2, 5);  // Request from floor 2 to floor 5
        elevatorSystem.requestElevator(7, 3);  // Request from floor 7 to floor 3
        elevatorSystem.requestElevator(1, 9);  // Request from floor 1 to floor 9
    }
}
