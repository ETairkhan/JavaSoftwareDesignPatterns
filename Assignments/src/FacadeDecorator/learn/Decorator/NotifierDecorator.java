package FacadeDecorator.learn.Decorator;

// Базовый декоратор
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapped;

    public NotifierDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }
}