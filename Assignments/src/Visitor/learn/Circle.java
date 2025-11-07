package Visitor.learn;

public class Circle implements Shape{
    private int x,y,radius;
    private String id;

    public Circle(int x,int y, int radius, String id){
        this.x =x ;
        this.y = y;
        this.radius = radius;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v){
        v.visitCircle(this);
    }

    @Override
    public void move(int x, int y){
        this.x=x;
        this.y=y;
        System.out.println("Moving Circle" + id + " to (" + x + ", " + y + ")");

    }


    @Override
    public void draw(){
        System.out.println("Drawing Circle " + id + " at (" + x + ", " + y + ") with radius " + radius );
    }

}
