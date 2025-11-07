package Visitor.learn;

public interface Visitor {
    void visitDot(Dot d);
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
    void visitCompoundShape(CompoundShape cs);
}
