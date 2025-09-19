package Factory.learn.wheels;

public class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle(){
        return new Vehicle.TwoWheeler();
    }
}
