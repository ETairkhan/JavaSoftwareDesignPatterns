package FacadeDecorator.learn.Decorator;

// Декоратор для Slack уведомлений
public class SlackDecorator extends NotifierDecorator {
    private String slackChannel;

    public SlackDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        // Сначала отправляем базовое уведомление
        super.send(message);
        // Затем добавляем Slack
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("💬 Отправка Slack сообщения в канал " + slackChannel + ": " + message);
        // Реальная логика отправки в Slack
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Slack уведомления";
    }
}