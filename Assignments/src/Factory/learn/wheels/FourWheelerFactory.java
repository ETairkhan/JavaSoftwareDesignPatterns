package Factory.learn.wheels;

public class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle(){
        return new Vehicle.FourWheeler();
    }
}
