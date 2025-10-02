package Adapter.Test;

public class TextAdapter implements Displayable{
    private InputData inputData;

    public TextAdapter(InputData inputData) {
        this.inputData = inputData;
    }

    @Override
    public void display() {
        System.out.println("Text: " + inputData.getText() );
    }
}
