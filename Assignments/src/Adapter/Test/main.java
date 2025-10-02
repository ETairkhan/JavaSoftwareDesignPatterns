package Adapter.Test;



import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Text");
        String text = scanner.nextLine();

        InputData inputData = new InputData(text);


        Displayable textDisplay = new TextAdapter(inputData);
        Displayable weightDisplay = new WieghtAdapter(inputData);

        textDisplay.display();
        weightDisplay.display();
    }
}
