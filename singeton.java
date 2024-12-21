//lazy singleton
/* This implementation is not thread-safe. If multiple threads call getInstance() 
simultaneously when instance is null, it's possible to create multiple instances. */

class LazySingleton {
    // The single instance, initially null
    private static LazySingleton instance;
    
    // Private constructor to prevent instantiation
    private LazySingleton() {}
    
    // Public method to get the instance
    public static LazySingleton getInstance() {
        // Check if instance is null
        if (instance == null) {
            // If null, create a new instance
            instance = new LazySingleton();
        }
        // Return the instance (either newly created or existing)
        return instance;
    }
}

/* Thread-Safe Singleton
This is achieved by making the getInstance() method synchronized 
ensuring only one thread can execute this method at a time.
When a thread enters the synchronized method, it acquires a lock on the class object. 
Other threads must wait until the method is executed. */

class ThreadSafeSingleton {
    // The single instance, initially null
    private static ThreadSafeSingleton instance;
    
    // Private constructor to prevent instantiation
    private ThreadSafeSingleton() {}
    
    // Public method to get the instance, with synchronized keyword
    public static synchronized ThreadSafeSingleton getInstance() {
        // Check if instance is null
        if (instance == null) {
            // If null, create a new instance
            instance = new ThreadSafeSingleton();
        }
        // Return the instance (either newly created or existing)
        return instance;
    }
}

/*  Double-Checked Locking
This approach minimizes performance overhead from synchronization 
by only synchronizing when the object is first created.
It uses the volatile keyword to ensure that changes to the instance 
variable are immediately visible to other threads. */

class DoubleCheckedSingleton {
    // The single instance, initially null, marked as volatile
    private static volatile DoubleCheckedSingleton instance;
    
    // Private constructor to prevent instantiation
    private DoubleCheckedSingleton() {}
    
    // Public method to get the instance
    public static DoubleCheckedSingleton getInstance() {
        // First check (not synchronized)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (DoubleCheckedSingleton.class) {
                // Second check (synchronized)
                if (instance == null) {
                    // Create the instance
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        // Return the instance (either newly created or existing)
        return instance;
    }
}


/*  Eager Initialization
In this method, we rely on the JVM to create the singleton instance when the class is loaded. 
The JVM guarantees that the instance will be created before any thread access the instance variable.
This implementation is one of the simplest and inherently thread-safe without needing explicit synchronization.  */

class EagerSingleton {
    // The single instance, created immediately
    private static final EagerSingleton instance = new EagerSingleton();
    
    // Private constructor to prevent instantiation
    private EagerSingleton() {}
    
    // Public method to get the instance
    public static EagerSingleton getInstance() {
        return instance;
    }
}










