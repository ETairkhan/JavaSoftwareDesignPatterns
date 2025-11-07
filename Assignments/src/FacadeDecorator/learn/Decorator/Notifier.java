package FacadeDecorator.learn.Decorator;

// Базовый интерфейс для всех уведомлений
public interface Notifier {
    void send(String message);
    String getDescription();
}