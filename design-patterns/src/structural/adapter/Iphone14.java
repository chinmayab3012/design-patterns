package structural.adapter;

public class Iphone14 {
    private AppleCharger appleCharger;

    public Iphone14(AppleCharger appleCharger){
        this.appleCharger = appleCharger;
    }

    public void chargeIphone() {
        System.out.println("Charging Iphone 14");
        appleCharger.chargePhone();
    }
}
