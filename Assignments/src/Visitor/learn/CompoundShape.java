package Visitor.learn;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape{
    private List<Shape> children = new ArrayList<>();
    private String id;

    public CompoundShape(String id){
        this.id = id;
    }

    public void add(Shape shape){
        children.add(shape);
    }

    public List<Shape> getChildren(){
        return children;
    }

    public String getId(){
        return id;
    }

    @Override
    public void accept(Visitor v){
        v.visitCompoundShape(this);
    }

    @Override
    public void move(int x, int y){
        System.out.println("Moving CompoundShape " +id);
        for (Shape child : children){
            child.move(x,y);
        }
    }

    @Override
    public void draw(){
        System.out.println("Drawing CompoundShape " +id + " with " + children.size() + " children");

        for (Shape child : children){
            child.draw();
        }
    }
}
