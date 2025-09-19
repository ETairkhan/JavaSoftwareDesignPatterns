package Factory.Assignment.Factory;
import Factory.Assignment.Linux.LinuxConcrete;
import Factory.Assignment.MacOS.MacOSConcrete;
import Factory.Assignment.Windows.WindowsConcrete;
import Factory.Assignment.interfaces.*;
public abstract class FactoryConcrete {

    public static class WindowsFactory implements GUIFactory {
        @Override public UIComponents.Button createButton() { return new WindowsConcrete.WindowsButton(); }
        @Override public UIComponents.TextBox createTextBox() { return new WindowsConcrete.WindowsTextBox(); }
        @Override public UIComponents.Checkbox createCheckbox() { return new WindowsConcrete.WindowsCheckbox(); }
        @Override public UIComponents.RadioButton createRadioButton() { return new WindowsConcrete.WindowsRadioButton(); }
        @Override public UIComponents.Slider createSlider() { return new WindowsConcrete.WindowsSlider(); }
        @Override public UIComponents.Folder createFolder() { return new WindowsConcrete.WindowsFolder(); }
    }

    public static class MacOSFactory implements GUIFactory {
        @Override public UIComponents.Button createButton() { return new MacOSConcrete.MacOSButton(); }
        @Override public UIComponents.TextBox createTextBox() { return new MacOSConcrete.MacOSTextBox(); }
        @Override public UIComponents.Checkbox createCheckbox() { return new MacOSConcrete.MacOSCheckbox(); }
        @Override public UIComponents.RadioButton createRadioButton() { return new MacOSConcrete.MacOSRadioButton(); }
        @Override public UIComponents.Slider createSlider() { return new MacOSConcrete.MacOSSlider(); }
        @Override public UIComponents.Folder createFolder() { return new MacOSConcrete.MacOSFolder(); }
    }

    public static class LinuxFactory implements GUIFactory {
        @Override public UIComponents.Button createButton() { return new LinuxConcrete.LinuxButton(); }
        @Override public UIComponents.TextBox createTextBox() { return new LinuxConcrete.LinuxTextBox(); }
        @Override public UIComponents.Checkbox createCheckbox() { return new LinuxConcrete.LinuxCheckbox(); }
        @Override public UIComponents.RadioButton createRadioButton() { return new LinuxConcrete.LinuxRadioButton(); }
        @Override public UIComponents.Slider createSlider() { return new LinuxConcrete.LinuxSlider(); }
        @Override public UIComponents.Folder createFolder() { return new LinuxConcrete.LinuxFolder(); }
    }
}