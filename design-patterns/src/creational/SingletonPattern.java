package creational;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * creational.Singleton Design Pattern is a creational design pattern that
 * lets you ensure that a class has only one instance,
 * while providing a global access point to this instance.
 * <p>
 * Correct way to implement creational.Singleton
 * 1. private static volatile field
 * 2. private constructor
 * 3. in constructor, check if instance is not null throw runtime exception that use
 * getInstance to avoid reflection based instantiation
 * 4. override readResolve method to ensure deserialization of singleton returns same instance
 * 5. override clone method to ensure cloning of singleton and throw cloneNotSupportedException
 * 6. static get instance method to return instance
 */
public class SingletonPattern {
    public static void main(String[] args) {
        DatabaseConnectionSingleton databaseConnectionSingleton = DatabaseConnectionSingleton.getInstance();
        DatabaseConnectionSingleton databaseConnectionSingleton1 = DatabaseConnectionSingleton.getInstance();
        System.out.println(Objects.equals(databaseConnectionSingleton, databaseConnectionSingleton1));

        System.out.println(databaseConnectionSingleton.hashCode());
        System.out.println(databaseConnectionSingleton1.hashCode());

        // use reflection to create new instance
        try {
            Constructor<DatabaseConnectionSingleton> constructor = DatabaseConnectionSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DatabaseConnectionSingleton databaseConnectionSingleton2 = constructor.newInstance();
            System.out.println(Objects.equals(databaseConnectionSingleton, databaseConnectionSingleton2));

        }catch (Exception e) {
            e.printStackTrace();
        }



    }

}


class DatabaseConnectionSingleton {
    private static volatile DatabaseConnectionSingleton instance;

    private DatabaseConnectionSingleton() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() " +
                    "method to get the single instance of this class.");
        }
    }

    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("creational.Singleton cannot be cloned.");
    }

    public static DatabaseConnectionSingleton getInstance() {
        if(instance == null) {
            synchronized (DatabaseConnectionSingleton.class) {
                if(instance == null) {
                    instance = new DatabaseConnectionSingleton();
                    System.out.println("Instance created");
                }
            }
        }
        return instance;
    }

}


