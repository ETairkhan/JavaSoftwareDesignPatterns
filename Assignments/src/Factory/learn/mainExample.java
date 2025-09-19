//import Factory.learn.abstractExample.example1.*;
//import Factory.learn.abstractExample.example2.*;
//import Factory.learn.shape.*;
//import Factory.learn.wheels.*;
//import Factory.learn.transport.*;
//
//
//public class Main {
//    public static void main(String[] args) {
//        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
//        Client twoWheelerClient = new Client(twoWheelerFactory);
//        Vehicle twoWheeler = twoWheelerClient.getVehicle();
//        twoWheeler.printVehicle();
//
//        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
//        Client fourWheelerClient = new Client(fourWheelerFactory);
//        Vehicle fourWheeler = fourWheelerClient.getVehicle();
//        fourWheeler.printVehicle();
//
//        ShapeFactory factory = new ShapeFactory();
//        Shape shape = factory.getShape("circle");
//        shape.draw();
//
//        Logistics logistics = new RoadLogistics();
//        logistics.planDeliver();
//
//        FurnitureFactory factoryFurniture = new ModernFurnitureFactory();
//        Chair chair = factoryFurniture.createChair();
//        Sofa sofa = factoryFurniture.createSofa();
//        chair.sit();
//        sofa.lieOn();
//
//
//        GUIFactory guiFactory = new WinFactory();
//        Button button = guiFactory.createButton();
//        button.paint();
//
//    }
//
//}