package FacadeDecorator.learn.Decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎯 НАГЛЯДНЫЙ ПРИМЕР ДЕКОРАТОРА 🎯");
        System.out.println("=================================\n");

        demonstrateProblemWithoutDecorator();
        demonstrateSolutionWithDecorator();
        demonstrateDynamicConfiguration();
        demonstrateRealWorldScenario();
    }

    // ДЕМОНСТРАЦИЯ: ПРОБЛЕМА БЕЗ ДЕКОРАТОРА
    private static void demonstrateProblemWithoutDecorator() {
        System.out.println("❌ ПРОБЛЕМА: КАК БЫЛО БЫ БЕЗ ДЕКОРАТОРА");
        System.out.println("----------------------------------------");

        System.out.println("""
            Без декоратора нам пришлось бы создавать классы для каждой комбинации:
            
            class EmailNotifier {}                    // Только email
            class SMSNotifier {}                     // Только SMS  
            class FacebookNotifier {}                // Только Facebook
            class SlackNotifier {}                   // Только Slack
            class EmailSMSNotifier {}                // Email + SMS
            class EmailFacebookNotifier {}           // Email + Facebook
            class EmailSlackNotifier {}              // Email + Slack
            class SMSFacebookNotifier {}             // SMS + Facebook
            class SMSSlackNotifier {}                // SMS + Slack
            class FacebookSlackNotifier {}           // Facebook + Slack
            class EmailSMSFacebookNotifier {}        // Email + SMS + Facebook
            class EmailSMSSlackNotifier {}           // Email + SMS + Slack
            class EmailFacebookSlackNotifier {}      // Email + Facebook + Slack
            class SMSFacebookSlackNotifier {}        // SMS + Facebook + Slack
            class EmailSMSFacebookSlackNotifier {}   // Все вместе!
            
            😫 15 КЛАССОВ ДЛЯ 4 ТИПОВ УВЕДОМЛЕНИЙ!
            😫 При добавлении нового типа уведомлений - КОМБИНАТОРНЫЙ ВЗРЫВ!
            """);
    }

    // ДЕМОНСТРАЦИЯ: РЕШЕНИЕ С ДЕКОРАТОРОМ
    private static void demonstrateSolutionWithDecorator() {
        System.out.println("✅ РЕШЕНИЕ: ДЕКОРАТОР - ДИНАМИЧЕСКОЕ ДОБАВЛЕНИЕ ФУНКЦИОНАЛА");
        System.out.println("----------------------------------------------------------");

        // Создаем базовый нотификатор
        Notifier notifier = new BasicNotifier("user@example.com");
        System.out.println("1. 📧 Базовый нотификатор: " + notifier.getDescription());
        notifier.send("Ваш заказ готов!");

        System.out.println("\n--- Добавляем SMS уведомления ---");
        // Обертываем в SMS декоратор
        notifier = new SMSDecorator(notifier, "+7-999-123-45-67");
        System.out.println("2. 📱 + SMS: " + notifier.getDescription());
        notifier.send("Ваш заказ готов!");

        System.out.println("\n--- Добавляем Facebook уведомления ---");
        // Обертываем в Facebook декоратор
        notifier = new FacebookDecorator(notifier, "user_facebook_id");
        System.out.println("3. 👥 + Facebook: " + notifier.getDescription());
        notifier.send("Ваш заказ готов!");

        System.out.println("\n--- Добавляем Slack уведомления ---");
        // Обертываем в Slack декоратор
        notifier = new SlackDecorator(notifier, "#general");
        System.out.println("4. 💬 + Slack: " + notifier.getDescription());
        notifier.send("Ваш заказ готов!");

        System.out.println("\n🎉 ВСЕГО 4 КЛАССА + 1 ИНТЕРФЕЙС ДЛЯ ЛЮБЫХ КОМБИНАЦИЙ!");
    }

    // ДЕМОНСТРАЦИЯ: ДИНАМИЧЕСКАЯ КОНФИГУРАЦИЯ
    private static void demonstrateDynamicConfiguration() {
        System.out.println("\n⚙️  ДИНАМИЧЕСКАЯ КОНФИГУРАЦИЯ В РАНТАЙМЕ");
        System.out.println("---------------------------------------");

        ApplicationConfigurator configurator = new ApplicationConfigurator();

        // Сценарий 1: Только для критических уведомлений (SMS + Email)
        System.out.println("🔴 КРИТИЧЕСКИЕ УВЕДОМЛЕНИЯ:");
        Notifier criticalNotifier = configurator.configureNotifier(
                true, false, false,
                "admin@company.com", "+7-999-111-11-11", "", ""
        );
        criticalNotifier.send("СЕРВЕР УПАЛ!");

        // Сценарий 2: Для маркетинга (Все каналы)
        System.out.println("\n🟢 МАРКЕТИНГОВЫЕ УВЕДОМЛЕНИЯ:");
        Notifier marketingNotifier = configurator.configureNotifier(
                true, true, true,
                "user@example.com", "+7-999-222-22-22", "user_fb", "#marketing"
        );
        marketingNotifier.send("Новая акция! Скидка 50%!");

        // Сценарий 3: Только соцсети
        System.out.println("\n🔵 СОЦИАЛЬНЫЕ УВЕДОМЛЕНИЯ:");
        Notifier socialNotifier = configurator.configureNotifier(
                false, true, true,
                "user@example.com", "", "user_fb", "#social"
        );
        socialNotifier.send("Новый пост в блоге!");
    }

    // ДЕМОНСТРАЦИЯ: РЕАЛЬНЫЙ СЦЕНАРИЙ
    private static void demonstrateRealWorldScenario() {
        System.out.println("\n🏠 РЕАЛЬНЫЙ СЦЕНАРИЙ: СИСТЕМА БЕЗОПАСНОСТИ ДОМА");
        System.out.println("------------------------------------------------");

        System.out.println("""
            Представьте систему умного дома:
            
            Ситуация 1: 'Протечка воды'
            - Только SMS (срочно!)
            - Email (для логов)
            """);

        Notifier waterLeakNotifier = new SMSDecorator(
                new BasicNotifier("home@security.com"),
                "+7-999-333-33-33"
        );
        waterLeakNotifier.send("⚠️ ОБНАРУЖЕНА ПРОТЕЧКА ВОДЫ В ВАННОЙ!");

        System.out.println("""
            
            Ситуация 2: 'Открыта дверь'
            - Slack (уведомление охраны)
            - SMS (владельцу)
            - Email (лог)
            """);

        Notifier doorOpenNotifier = new SlackDecorator(
                new SMSDecorator(
                        new BasicNotifier("security@home.com"),
                        "+7-999-444-44-44"
                ),
                "#security-alerts"
        );
        doorOpenNotifier.send("🚪 ВХОДНАЯ ДВЕРЬ ОТКРЫТА БОЛЕЕ 5 МИНУТ");

        System.out.println("""
            
            Ситуация 3: 'Праздник' 
            - Facebook (гостям)
            - Slack (семье)
            - Email (подтверждение)
            """);

        Notifier partyNotifier = new FacebookDecorator(
                new SlackDecorator(
                        new BasicNotifier("family@home.com"),
                        "#family-chat"
                ),
                "family_events"
        );
        partyNotifier.send("🎉 ВЕЧЕРИНКА В СУББОТУ В 19:00!");
    }

    // ДЕМОНСТРАЦИЯ: ПРЕИМУЩЕСТВА ДЕКОРАТОРА
    private static void demonstrateAdvantages() {
        System.out.println("\n🌟 ПРЕИМУЩЕСТВА ДЕКОРАТОРА");
        System.out.println("-------------------------");

        System.out.println("""
            1. 🎯 ОТКРЫТО/ЗАКРЫТ ПРИНЦИП
               - Добавляем новые декораторы без изменения существующего кода
               
            2. 🔄 ДИНАМИЧЕСКОЕ ИЗМЕНЕНИЕ ПОВЕДЕНИЯ
               - Можем добавлять/убирать функциональность в runtime
               
            3. 🧩 КОМПОНОВКА ЛЮБОЙ СЛОЖНОСТИ
               - Собираем любые комбинации без комбинаторного взрыва классов
               
            4. 🎪 ЕДИНЫЙ ИНТЕРФЕЙС
               - Клиентский код работает с любыми комбинациями одинаково
               
            5. 🧹 ЧИСТОТА КОДА
               - Каждый декоратор отвечает только за одну функциональность
            """);

        // Пример гибкости
        System.out.println("Пример гибкости - меняем конфигурацию на лету:");

        Notifier notifier = new BasicNotifier("test@example.com");
        System.out.println("Начальная конфигурация: " + notifier.getDescription());

        // Добавляем функциональность
        notifier = new SMSDecorator(notifier, "+7-999-555-55-55");
        System.out.println("После добавления SMS: " + notifier.getDescription());

        // "Убираем" SMS (создаем новую цепочку без SMS)
        notifier = new FacebookDecorator(
                new BasicNotifier("test@example.com"),
                "test_fb"
        );
        System.out.println("Без SMS, только Facebook: " + notifier.getDescription());
    }
}

