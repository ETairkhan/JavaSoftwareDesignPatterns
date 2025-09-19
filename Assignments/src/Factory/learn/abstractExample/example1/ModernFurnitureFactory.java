package Factory.learn.abstractExample.example1;

public class ModernFurnitureFactory implements FurnitureFactory{
    public Chair createChair(){
        return new Concrete.ModernChair();
    }
    public Sofa createSofa(){
        return new Concrete.ModernSofa();
    }
}
