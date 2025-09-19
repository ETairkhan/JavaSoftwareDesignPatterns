package Factory.learn.shape;

public abstract class ShapeAbstract  implements Shape{
   public static class Circle extends ShapeAbstract{
       public void draw(){
           System.out.println("Draw the circle");
       }
   }

   public static class Square extends ShapeAbstract{
       public void smile(){
           System.out.println("Smile");
       }
       public void draw(){
           System.out.println("Draw the square");
       }
   }
}
