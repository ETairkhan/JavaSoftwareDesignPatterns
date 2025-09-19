package Factory.learn.abstractExample.example1;

public abstract class Concrete {
    public static class ModernChair implements Chair{
        public void sit(){
            System.out.println("Modern chair");
        }
    }
    public static class ModernSofa implements Sofa{
        public void lieOn(){
            System.out.println("Modern sofa");
        }
    }
}
