package Visitor.learn;

public class Dot implements Shape{
    private int x, y;
    private String id;
    public Dot(int x, int y, String id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v){
        v.visitDot(this);
    }

    @Override
    public void move(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("Moving Dot " + id + " to (" + x + ", " + y +")");
    }

    @Override
    public void draw(){
        System.out.println("Drawing Dot " + id + " at (" + x + ", " + y + ")");
    }
}
