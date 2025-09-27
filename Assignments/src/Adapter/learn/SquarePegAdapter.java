package Adapter.learn;
// Adapter : makes a SquarePeg behave like a RoundPeg
public class SquarePegAdapter extends RoundPeg{
    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg){
        // We call the parent constructor with 0 because
        // we'll override getRadius() anyway.
        super(0);
        this.peg = peg;
    }

    @Override
    public double getRadius(){
        // Calculate the minimum circle radius that fits the square
        // half of the square's diagonal: width * sqrt(2) / 2
        return peg.getWidth() * Math.sqrt(2) / 2;
    }
}
