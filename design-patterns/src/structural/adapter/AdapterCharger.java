package structural.adapter;

//adapter class
public class AdapterCharger implements AppleCharger{
    AndriodCharger andriodCharger;

    public AdapterCharger(AndriodCharger andriodCharger) {
        this.andriodCharger = andriodCharger;
    }

    @Override
    public void chargePhone() {
        andriodCharger.chargeAndriodPhone();
        System.out.println("Charging phone with AdapterCharger");
    }
}
