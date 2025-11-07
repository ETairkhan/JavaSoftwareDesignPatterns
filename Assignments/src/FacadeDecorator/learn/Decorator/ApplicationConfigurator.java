package FacadeDecorator.learn.Decorator;

// Конфигуратор приложения - собирает нужные комбинации декораторов
public class ApplicationConfigurator {

    public Notifier configureNotifier(boolean smsEnabled, boolean facebookEnabled,
                                      boolean slackEnabled, String email,
                                      String phone, String facebookId, String slackChannel) {

        Notifier notifier = new BasicNotifier(email);

        if (smsEnabled) {
            notifier = new SMSDecorator(notifier, phone);
        }

        if (facebookEnabled) {
            notifier = new FacebookDecorator(notifier, facebookId);
        }

        if (slackEnabled) {
            notifier = new SlackDecorator(notifier, slackChannel);
        }

        return notifier;
    }
}