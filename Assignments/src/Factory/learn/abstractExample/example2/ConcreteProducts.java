package Factory.learn.abstractExample.example2;

public abstract class ConcreteProducts {
    public static class WinButton  implements Button {
        public void paint(){
            System.out.println("Win Button");
        }
    }

    public static class WinCheckbox implements Checkbox {
        public void paint(){
            System.out.println("Win Checkbox");
        }
    }
}
