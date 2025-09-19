package Factory.learn.shape;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new ShapeAbstract.Circle();
        }else if  (shapeType.equalsIgnoreCase("SQUARE")) {
            return new ShapeAbstract.Square();
        }else{
            return null;
        }
    }
}
