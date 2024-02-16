package cpp.cs5800.adv_swe.assignment1.polymorphism;

public class CruiseShip extends Ship{

    int maxNumberOfPassengers;
    public CruiseShip()
    {

    }

    public CruiseShip(String shipName, String yearShipWasBuilt, int maxNumberOfPassengers) {
        super(shipName, yearShipWasBuilt);
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public void display()
    {
        System.out.println("Printing details from Child Class: CruiseShip");
        System.out.println("shipName=\t"+shipName+"\n"+"maxNumberOfPassengers=\t"+maxNumberOfPassengers);

    }
}
