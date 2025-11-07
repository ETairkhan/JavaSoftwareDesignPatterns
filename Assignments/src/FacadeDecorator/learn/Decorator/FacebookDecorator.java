package FacadeDecorator.learn.Decorator;
// Декоратор для Facebook уведомлений
public class FacebookDecorator extends NotifierDecorator {
    private String facebookId;

    public FacebookDecorator(Notifier notifier, String facebookId) {
        super(notifier);
        this.facebookId = facebookId;
    }

    @Override
    public void send(String message) {
        // Сначала отправляем базовое уведомление
        super.send(message);
        // Затем добавляем Facebook
        sendFacebookMessage(message);
    }

    private void sendFacebookMessage(String message) {
        System.out.println("👥 Отправка Facebook сообщения для " + facebookId + ": " + message);
        // Реальная логика отправки в Facebook
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Facebook уведомления";
    }
}