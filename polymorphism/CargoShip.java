package cpp.cs5800.adv_swe.assignment1.polymorphism;

public class CargoShip extends Ship{
    int shipCapacity;

    public CargoShip(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public CargoShip(String shipName, String yearShipWasBuilt, int shipCapacity) {
        super(shipName, yearShipWasBuilt);
        this.shipCapacity = shipCapacity;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public void display()
    {
        System.out.println("Printing details from Child Class: CargoShip");
        System.out.println("shipName=\t"+shipName+"\n"+"shipCapacity=\t"+shipCapacity);
    }
}
