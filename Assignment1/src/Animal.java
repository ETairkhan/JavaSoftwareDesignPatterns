public class Animal {
    private String name;
    private String type;
    private int height;
    private int weight;
    private String continent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString(){
        return "The animal name is " + this.name + ", its type is " + this.type +
                ". Animal weight and height are " + this.weight + "kg and " +
                this.height + "cm. This species lives only in " + this.continent;
    }
}
