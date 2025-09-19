package Factory.learn.abstractExample.example2;

public class WinFactory implements GUIFactory{
    public Button createButton(){
        return new ConcreteProducts.WinButton();
    }
    public Checkbox createCheckbox(){
        return new ConcreteProducts.WinCheckbox();
    }
}
