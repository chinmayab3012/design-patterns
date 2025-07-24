package structural.adapter;

/**
 * Adapter Pattern is a structural design pattern that allows
 * objects with incompatible interfaces to collaborate together by
 * converting the interface of one object to match the interface of
 * another object.
 * <p>
 * In Adapter Pattern, we create an adapter class that converts
 * the interface of one object to match the interface of another
 * object.
 * <p>
 * Adapter Pattern is useful when we want to use objects with
 * different interfaces in a unified way.
 * <p>
 *  Step 1: Create an adapter class that implements the target interface.
 *  Step 2: Create objects of the source and target interfaces.
 *  Step 3: Pass the source object to the adapter class.
 *  Step 4: Call the target interface method on the adapter class.
 *  <p>
 *
 *
 */

public class Demo {
    public static void main(String[] args) {
        System.out.println("Program started");

        AndriodCharger andriodCharger = new ChargerSRT();
        AppleCharger appleCharger = new AdapterCharger(andriodCharger);

        Iphone14 iphone14 = new Iphone14(appleCharger);
        iphone14.chargeIphone();
    }
}
