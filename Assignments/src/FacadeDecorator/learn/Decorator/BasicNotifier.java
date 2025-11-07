package FacadeDecorator.learn.Decorator;

// Базовая реализация - только email уведомления
public class BasicNotifier implements Notifier {
    private String email;

    public BasicNotifier(String email) {
        this.email = email;
    }

    @Override
    public void send(String message) {
        System.out.println("📧 Отправка email на " + email + ": " + message);
        // Здесь была бы реальная логика отправки email
    }

    @Override
    public String getDescription() {
        return "Базовые email уведомления";
    }
}