package FacadeDecorator.learn.Decorator;


// Декоратор для SMS уведомлений
public class SMSDecorator extends NotifierDecorator {
    private String phoneNumber;

    public SMSDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        // Сначала отправляем базовое уведомление
        super.send(message);
        // Затем добавляем SMS
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("📱 Отправка SMS на " + phoneNumber + ": " + message);
        // Реальная логика отправки SMS
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + SMS уведомления";
    }
}