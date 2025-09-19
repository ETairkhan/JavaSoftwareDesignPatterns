package Factory.learn.wheels;

public abstract class Vehicle {
    public abstract void printVehicle();

    public static class  TwoWheeler extends Vehicle {
        public void printVehicle() {
            System.out.println("Two Wheeler");
        }
    }

    public static class  FourWheeler extends Vehicle {
        public void printVehicle(){
            System.out.println("Four Wheeler");
        }
    }
}
