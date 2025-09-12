package learningWIthAnimalsBuilder;

public interface AnimalBuilder {
    void setWings(String Wings);
    void setSpeed(int speed);
    void setHeight(int height);
    void setWeight(int weight);
    void getHeight();
    Animal build();
}
