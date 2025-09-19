package Factory.Assignment.interfaces;

public interface UIComponents {
    interface Button {
        void render();
        void onClick();
    }

    interface TextBox {
        void render();
        void setText(String text);
    }

    interface Checkbox {
        void render();
        void toggle();
        boolean isChecked();
    }

    interface RadioButton {
        void render();
        void select();
        boolean isSelected();
    }

    interface Slider {
        void render();
        void setValue(int value);
        int getValue();
    }

    interface Folder {
        void render();
        void addItem(String item);
        void open();
    }
}
