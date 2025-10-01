package Bridge;

import Bridge.Assignment.Works;
import Bridge.learn.RedCircle;
import Bridge.learn.Shape;
import Bridge.PracticalExample.Vehicle;
import Bridge.PracticalExample.WorkShops;
import Bridge.Assignment.OS;
import Bridge.Assignment.Works;

public class Main {
    public static void main(String[] args){
        // Create circles with different implementations
        Shape redCircle = new Shape.Circle(100, 100, 10, new RedCircle());

        // Draw the circles
        redCircle.draw();

        Vehicle vehicle1 = new Vehicle.Car(new WorkShops.Produce(), new WorkShops.Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Vehicle.Bike(new WorkShops.Produce(), new WorkShops.Assemble());
        vehicle2.manufacture();

        OS osWindows = new OS.WindowsOS(new Works.Terminal(), new Works.FileExplorer());
        osWindows.coding();
    }
}
