package Visitor.learn;

public class Rectangle implements Shape {
    private int x,y,width,height;
    private String id;
    public Rectangle(int x, int y, int width, int height, String id){
        this.x= x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v){
        v.visitRectangle(this);
    }

    @Override
    public void move(int x, int y){
        this.x=x;
        this.y=y;
        System.out.println("Moving Rectangle" + id + " to (" + x + ", " + y + ")");

    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle " + id + " at (" + x + ", " + y + ") with size " + width + "x" + height);
    }
}
