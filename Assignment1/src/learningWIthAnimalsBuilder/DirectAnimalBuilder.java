package learningWIthAnimalsBuilder;

public class DirectAnimalBuilder {
    public Animal construct(AnimalBuilder builder){
        builder.setHeight(10);
        builder.setSpeed(20);
        builder.setWings("Black wings");
        builder.setWeight(20);
        return builder.build();
    }
}
