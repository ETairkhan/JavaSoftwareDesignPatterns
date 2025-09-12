public class AnimalConcrete implements AnimalBuilder {
    Animal animal = new Animal();

    @Override
    public void setName(String name){
        animal.setName(name);
    }

    @Override
    public void setType(String type){
        animal.setType(type);
    }

    @Override
    public void setHeight(int height){
        animal.setHeight(height);
    }

    @Override
    public void setWeight(int weight){
        animal.setWeight(weight);
    }

    @Override
    public void setContinent(String continent){
        animal.setContinent(continent);
    }

    @Override
    public Animal build(){
        return animal;
    }
}
