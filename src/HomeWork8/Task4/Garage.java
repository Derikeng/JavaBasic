package HomeWork8.Task4;

public class Garage<G extends Vehicle> {
    private final G vehicles;

    public Garage(G vehicles) {
        this.vehicles = vehicles;
    }

    public String getVehicleName() {
        return vehicles.getName();
    }
}
