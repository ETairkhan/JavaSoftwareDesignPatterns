package Adapter.Test;

public class WieghtAdapter implements Displayable{
    private InputData inputData;

    public WieghtAdapter(InputData inputData) {
        this.inputData= inputData;
    }
    @Override
    public void display() {
        System.out.println("Character positions in input:");
        char[] chars = inputData.getText().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " -> " + (i + 1) + " kg");
        }
    }
}
