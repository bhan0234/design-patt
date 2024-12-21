// Step 1: Product Interface
interface Transport {
    void deliver();
}

// Step 2: Concrete Products
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by road in a truck.");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea in a ship.");
    }
}

// Step 3: Creator (Factory)
abstract class Logistics {
    // Factory Method
    abstract Transport createTransport();

    // Common behavior using the product
    void planDelivery() {
        Transport transport = createTransport(); // Use factory method to get product
        transport.deliver();
    }
}

// Step 4: Concrete Creators
class RoadLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Truck(); // Creates a Truck
    }
}

class SeaLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Ship(); // Creates a Ship
    }
}

// Step 5: Client Code
public class Main {
    public static void main(String[] args) {
        // Road delivery
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        // Sea delivery
        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}
