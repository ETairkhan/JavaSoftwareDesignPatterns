package Factory.Assignment.Windows;
import Factory.Assignment.interfaces.*;

public abstract class WindowsConcrete {

    public static class WindowsButton implements UIComponents.Button {
        @Override public void render() { System.out.println("Rendering Windows button with classic gray theme"); }
        @Override public void onClick() { System.out.println("Windows button clicked with satisfying click sound"); }
    }

    public static class WindowsTextBox implements UIComponents.TextBox {
        @Override public void render() { System.out.println("Rendering Windows textbox with beveled edges"); }
        @Override public void setText(String text) { System.out.println("Windows textbox set to: " + text); }
    }

    public static class WindowsCheckbox implements UIComponents.Checkbox {
        private boolean checked = false;
        @Override public void render() { System.out.println("Rendering Windows checkbox" + (checked ? " (checked)" : "")); }
        @Override public void toggle() { checked = !checked; System.out.println("Windows checkbox toggled"); }
        @Override public boolean isChecked() { return checked; }
    }

    public static class WindowsRadioButton implements UIComponents.RadioButton {
        private boolean selected = false;
        @Override public void render() { System.out.println("Rendering Windows radio button" + (selected ? " (selected)" : "")); }
        @Override public void select() { selected = true; System.out.println("Windows radio button selected"); }
        @Override public boolean isSelected() { return selected; }
    }

    public static class WindowsSlider implements UIComponents.Slider {
        private int value = 50;
        @Override public void render() { System.out.println("Rendering Windows slider at value: " + value); }
        @Override public void setValue(int value) { this.value = value; System.out.println("Windows slider set to: " + value); }
        @Override public int getValue() { return value; }
    }

    public static class WindowsFolder implements UIComponents.Folder {
        @Override public void render() { System.out.println("Rendering Windows folder"); }
        @Override public void addItem(String item) { System.out.println("Added '" + item + "' to Windows folder"); }
        @Override public void open() { System.out.println("Opening Windows folder"); }
    }
}