package Visitor.learn;

public interface Shape {
    void move(int x, int y);
    void draw();
    void accept(Visitor v);
}
