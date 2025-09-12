public class AnimalDirector {
    private final AnimalBuilder builder;

    public AnimalDirector(AnimalBuilder builder){
        this.builder = builder;
    }

    public Animal buildTiger(){
        builder.setName("Tiger");
        builder.setType("Amur tiger");
        builder.setWeight(300);
        builder.setHeight(300);
        builder.setContinent("Asia");
        return builder.build();
    }

    public Animal buildElephant(){
        builder.setName("Elephant");
        builder.setType("African Elephant");
        builder.setWeight(3500);
        builder.setHeight(2600);
        builder.setContinent("Africa");
        return builder.build();
    }

    public Animal buildDog(){
        builder.setName("Dog");
        builder.setWeight(24);
        builder.setHeight(34);
        builder.setContinent("World");
        return builder.build();
    }

}
