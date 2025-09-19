package Factory.Assignment;

import Factory.Assignment.interfaces.UIComponents;

public abstract class MacOSConcrete {
    public static class MacOSButton implements UIComponents.Button {
        @Override public void render() { System.out.println("Rendering macOS button with smooth glass effect"); }
        @Override public void onClick() { System.out.println("macOS button clicked with gentle animation"); }
    }

    public static class MacOSTextBox implements UIComponents.TextBox {
        @Override public void render() { System.out.println("Rendering macOS textbox with rounded corners"); }
        @Override public void setText(String text) { System.out.println("macOS textbox set to: " + text); }
    }

    public static class MacOSCheckbox implements UIComponents.Checkbox {
        private boolean checked = false;
        @Override public void render() { System.out.println("Rendering macOS checkbox" + (checked ? " ✓" : "")); }
        @Override public void toggle() { checked = !checked; System.out.println("macOS checkbox toggled with smooth transition"); }
        @Override public boolean isChecked() { return checked; }
    }

    public static class MacOSRadioButton implements UIComponents.RadioButton {
        private boolean selected = false;
        @Override public void render() { System.out.println("Rendering macOS radio button" + (selected ? " ●" : " ○")); }
        @Override public void select() { selected = true; System.out.println("macOS radio button selected with animation"); }
        @Override public boolean isSelected() { return selected; }
    }

    public static class MacOSSlider implements UIComponents.Slider {
        private int value = 50;
        @Override public void render() { System.out.println("Rendering macOS slider (circular knob) at value: " + value); }
        @Override public void setValue(int value) { this.value = value; System.out.println("macOS slider set to: " + value); }
        @Override public int getValue() { return value; }
    }

    public static class MacOSFolder implements UIComponents.Folder {
        @Override public void render() { System.out.println("Rendering macOS folder"); }
        @Override public void addItem(String item) { System.out.println("Added '" + item + "' to macOS folder"); }
        @Override public void open() { System.out.println("Opening macOS folder"); }
    }
}