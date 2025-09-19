package Factory.Assignment;
import Factory.Assignment.interfaces.*;

import java.util.Scanner;

public class Client {
    private final UIComponents.Button button;
    private final UIComponents.TextBox textBox;
    private final UIComponents.Checkbox checkbox;
    private final UIComponents.RadioButton radioButton;
    private final UIComponents.Slider slider;
    private final UIComponents.Folder folder;

    public Client(GUIFactory factory) {
        this.button = factory.createButton();
        this.textBox = factory.createTextBox();
        this.checkbox = factory.createCheckbox();
        this.radioButton = factory.createRadioButton();
        this.slider = factory.createSlider();
        this.folder = factory.createFolder();
    }

    public static GUIFactory choice(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose OS type:");
        System.out.println("1. Windows");
        System.out.println("2. macOS");
        System.out.println("3. Linux");
        System.out.print("Enter your choice (1, 2, or 3): ");

        int choice = scanner.nextInt();
        scanner.close();

        switch (choice) {
            case 1:
                System.out.println("\nCreating Windows UI components...");
                return new FactoryConcrete.WindowsFactory();
            case 2:
                System.out.println("\nCreating macOS UI components...");
                return new FactoryConcrete.MacOSFactory();
            case 3:
                System.out.println("\nCreating Linux UI components...");
                return new FactoryConcrete.LinuxFactory();
            default:
                System.out.println("Invalid choice. Using Windows as default.");
                return new FactoryConcrete.WindowsFactory();
        }
    }

    public void renderUI() {
        System.out.println("\n=== Rendering Complete UI ===");
        button.render();
        textBox.render();
        checkbox.render();
        radioButton.render();
        slider.render();
        folder.render();
        System.out.println("============================\n");
    }

    public void simulateUserInteraction() {
        System.out.println("=== Simulating User Interaction ===");
        button.onClick();
        textBox.setText("Hello World!");
        checkbox.toggle();
        radioButton.select();
        slider.setValue(75);
        folder.addItem("File");
        folder.open();
        System.out.println("Checkbox is checked: " + checkbox.isChecked());
        System.out.println("Radio button is selected: " + radioButton.isSelected());
        System.out.println("Slider value: " + slider.getValue());
        System.out.println("===================================\n");
    }
}