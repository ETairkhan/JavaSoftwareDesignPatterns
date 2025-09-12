package learningWIthAnimalsBuilder;

public class ConcreteAnimalBuilder implements AnimalBuilder {
    private Animal animal = new Animal();
    @Override
    public void setWings(String Wings){
        animal.setWings(Wings);
    }
    @Override
    public void setSpeed(int Speed){
        animal.setSpeed(Speed);
    }

    @Override
    public void setHeight(int Height){
        animal.setHeight(Height);
    }

    @Override
    public void setWeight(int Weight){
        animal.setWeight(Weight);
    }

    @Override
    public void getHeight(){
    }

    @Override
    public Animal build(){
        return animal;
    }
}
