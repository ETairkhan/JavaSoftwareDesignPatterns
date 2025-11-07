package FacadeDecorator.learn.Facade;

import FacadeDecorator.learn.Facade.facade.VideoConverter;
import FacadeDecorator.learn.Facade.subsystem.AudioMixer;
import FacadeDecorator.learn.Facade.subsystem.BitrateReader;
import FacadeDecorator.learn.Facade.subsystem.CodecFactory;
import FacadeDecorator.learn.Facade.subsystem.VideoFile;
import FacadeDecorator.learn.Facade.subsystem.codecs.VideoCodec;

// Клиент использует только фасад
public class Client {
    public static void main(String[] args) {
        System.out.println("🎯 ПОНЯТНЫЙ ПРИМЕР ФАСАДА 🎯");
        System.out.println("============================\n");

        demonstrateWithoutFacade();
        demonstrateWithFacade();
    }

    // ДЕМОНСТРАЦИЯ: КАК БЫЛО БЕЗ ФАСАДА (СЛОЖНО)
    private static void demonstrateWithoutFacade() {
        System.out.println("❌ БЕЗ ФАСАДА: Клиенту нужно знать ВСЮ систему");
        System.out.println("------------------------------------------------");

        try {
            // Клиенту приходится работать со ВСЕМИ компонентами напрямую:

            // 1. Работа с файлом
            VideoFile file = new VideoFile("family_vacation.ogg");
            System.out.println("1. 📁 Анализ файла: " + file.getFilename());

            // 2. Работа с фабрикой кодеков
            VideoCodec sourceCodec = CodecFactory.extract(file);
            VideoCodec destCodec = CodecFactory.createCodecForFormat("mp4");
            System.out.println("2. 🔧 Определение кодеков: " +
                    sourceCodec.getName() + " → " + destCodec.getName());

            // 3. Работа с ридером
            String buffer = BitrateReader.read(file.getFilename(), sourceCodec);
            System.out.println("3. 📖 Чтение видео данных");

            // 4. Конвертация
            String convertedVideo = BitrateReader.convert(buffer, sourceCodec, destCodec);
            System.out.println("4. 🔄 Конвертация видео");

            // 5. Работа с аудио
            AudioMixer mixer = new AudioMixer();
            String finalResult = mixer.fixAudio(convertedVideo);
            finalResult = mixer.normalizeAudio(finalResult);
            System.out.println("5. 🎵 Обработка аудио");

            System.out.println("✅ Результат: " + finalResult.substring(0, 30) + "...");
            System.out.println("😫 Клиент устал! Он знает слишком много о системе!");

        } catch (Exception e) {
            System.out.println("❌ Ошибка: " + e.getMessage());
        }
    }

    // ДЕМОНСТРАЦИЯ: КАК СТАЛО С ФАСАДОМ (ПРОСТО)
    private static void demonstrateWithFacade() {
        System.out.println("\n✅ С ФАСАДОМ: Клиенту нужно знать только Фасад");
        System.out.println("-----------------------------------------------");

        // Фасад скрывает всю сложность!
        VideoConverter converter = new VideoConverter(); // Единственный класс, который знает клиент

        System.out.println("🎯 Клиент говорит: 'Хочу конвертировать video.ogg в mp4'");
        String result = converter.convert("family_vacation.ogg", "mp4");

        if (result != null) {
            System.out.println("✅ Результат: " + result.substring(0, 30) + "...");
            System.out.println("😊 Клиент доволен! Ему не нужно знать о сложной системе!");
        }

        System.out.println("\n🎯 Клиент говорит: 'Хочу конвертировать другой файл с эффектами'");
        String result2 = converter.convertWithEffects("presentation.ogv", "mp4");

        if (result2 != null) {
            System.out.println("✅ Результат: " + result2.substring(0, 30) + "...");
        }
    }

    // ДЕМОНСТРАЦИЯ РЕАЛЬНОГО СЦЕНАРИЯ
    private static void demonstrateRealWorldScenario() {
        System.out.println("\n🏠 РЕАЛЬНЫЙ СЦЕНАРИЙ: Видео-редактор");
        System.out.println("-----------------------------------");

        // Представьте, что это графический видеоредактор
        VideoConverter videoConverter = new VideoConverter();

        // Пользователь нажимает кнопку "Конвертировать в MP4"
        System.out.println("👤 Пользователь: Выбирает файл 'wedding.ogg'");
        System.out.println("👤 Пользователь: Нажимает 'Конвертировать в MP4'");

        // Программа использует Фасад
        String convertedVideo = videoConverter.convert("wedding.ogg", "mp4");

        if (convertedVideo != null) {
            System.out.println("✅ Видео успешно сконвертировано!");
            System.out.println("👤 Пользователь: 'Отлично! Просто нажал кнопку!'");
        }

        // Пользователь НЕ ЗНАЕТ о:
        // - CodecFactory, BitrateReader, AudioMixer
        // - MPEG4CompressionCodec, OggCompressionCodec
        // - Процессе декомпрессии/компрессии
        // - Обработке аудио дорожки
    }
}