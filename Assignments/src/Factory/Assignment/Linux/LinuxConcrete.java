package Factory.Assignment.Linux;

import Factory.Assignment.interfaces.UIComponents;

public abstract class LinuxConcrete {
    public static class LinuxButton implements UIComponents.Button {
        @Override public void render() { System.out.println("Rendering Linux button (GTK theme)"); }
        @Override public void onClick() { System.out.println("Linux button clicked"); }
    }

    public static class LinuxTextBox implements UIComponents.TextBox {
        @Override public void render() { System.out.println("Rendering Linux textbox"); }
        @Override public void setText(String text) { System.out.println("Linux textbox set to: " + text); }
    }

    public static class LinuxCheckbox implements UIComponents.Checkbox {
        private boolean checked = false;
        @Override public void render() { System.out.println("Rendering Linux checkbox"); }
        @Override public void toggle() { checked = !checked; System.out.println("Linux checkbox toggled"); }
        @Override public boolean isChecked() { return checked; }
    }

    public static class LinuxRadioButton implements UIComponents.RadioButton {
        private boolean selected = false;
        @Override public void render() { System.out.println("Rendering Linux radio button"); }
        @Override public void select() { selected = true; System.out.println("Linux radio button selected"); }
        @Override public boolean isSelected() { return selected; }
    }

    public static class LinuxSlider implements UIComponents.Slider {
        private int value = 50;
        @Override public void render() { System.out.println("Rendering Linux slider at value: " + value); }
        @Override public void setValue(int value) { this.value = value; System.out.println("Linux slider set to: " + value); }
        @Override public int getValue() { return value; }
    }

    public static class LinuxFolder implements UIComponents.Folder {
        @Override public void render() { System.out.println("Rendering Linux folder"); }
        @Override public void addItem(String item) { System.out.println("Added '" + item + "' to Linux folder"); }
        @Override public void open() { System.out.println("Opening Linux folder"); }
    }
}