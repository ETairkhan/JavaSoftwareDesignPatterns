package Visitor.learn;

public class XMLExportVisitor implements Visitor{
    @Override
    public void visitDot(Dot d){
        System.out.println("<dot id=\"" + d.getId() +"\">");
        System.out.println(" <x> " + d.getX() + "</x>");
        System.out.println(" <y> " + d.getY() + "</y>");
        System.out.println("</dot>");
    }

    @Override
    public void visitCircle(Circle c){
        System.out.println("<circle id=\"" + c.getId() + "\">");
        System.out.println(" <x> " + c.getX() + "</x>");
        System.out.println(" <y> " + c.getY() + "</y>");
        System.out.println(" <radius> " + c.getRadius() + "</radius>");
        System.out.println("</circle>");
    }

    @Override
    public void visitRectangle(Rectangle r){
        System.out.println("<rectangle id=\"" + r.getId() + "\">");
        System.out.println(" <x> " + r.getX() + "</x>");
        System.out.println(" <y> " + r.getY() + "</y>");
        System.out.println(" <width> " + r.getWidth() + "</width>");
        System.out.println(" <height> " + r.getHeight() + "</height>");
        System.out.println("</rectangle>");
    }

    @Override
    public void visitCompoundShape(CompoundShape c){
        System.out.println("<compoundShape id=\"" + c.getId() + "\">");
        System.out.println(" <children>");
        for (Shape child : c.getChildren()){
            child.accept(this);
        }
        System.out.println("</children>");
        System.out.println("</compoundShape>");
    }
}
