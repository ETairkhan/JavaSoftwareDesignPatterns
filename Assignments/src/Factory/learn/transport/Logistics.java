package Factory.learn.transport;

public abstract class Logistics {
    public abstract Transport createTransport();
    public void planDeliver(){
        Transport t = createTransport();
        t.deliver();
    }
}
