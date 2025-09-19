package Factory.Assignment.interfaces;

public interface GUIFactory {
    UIComponents.Button createButton();
    UIComponents.TextBox createTextBox();
    UIComponents.Checkbox createCheckbox();
    UIComponents.RadioButton createRadioButton();
    UIComponents.Slider createSlider();
    UIComponents.Folder createFolder();
}
