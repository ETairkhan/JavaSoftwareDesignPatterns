package Visitor.learn;

import java.util.List;
import java.util.ArrayList;
public class Application {
    private List<Shape> allShapes = new ArrayList<>();

    public void export(){
        Visitor exportVisitor = new XMLExportVisitor();
        System.out.println("Exporting shapes to XML:");
        System.out.println("========================");
        for (Shape shape : allShapes){
            shape.accept(exportVisitor);
            System.out.println();
        }
    }

    public void addShape(Shape shape){
        allShapes.add(shape);
    }

    public void demo(){
        // Create some shapes
        Dot dot = new Dot(10, 20, "dot1");
        Circle circle = new Circle(30, 40 ,15, "circle1");
        Rectangle rectangle = new Rectangle(50,60,100,200, "rect1");

        // Create a compound shape
        CompoundShape compound = new CompoundShape("compound1");
        compound.add(new Dot(70, 80, "dot2"));
        compound.add(new Circle(90, 100,25, "circle2"));

        // Add all shapes to application
        addShape(dot);
        addShape(circle);
        addShape(rectangle);
        addShape(compound);

        //Draw all shapes
        System.out.println("Drawing all shapes:");
        System.out.println("===================");
        for (Shape shape : allShapes){
            shape.draw();
        }
        System.out.println();

        // Export all shapes
        export();
    }
}
