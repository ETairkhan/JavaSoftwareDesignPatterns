package Builder;

public interface AnimalBuilder {
    void setName(String name);
    void setType(String type);
    void setWeight(int weight);
    void setHeight(int height);
    void setContinent(String continent);
    Animal build();
}
