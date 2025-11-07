package FacadeDecorator.learn.Facade.facade;

import FacadeDecorator.learn.Facade.subsystem.AudioMixer;
import FacadeDecorator.learn.Facade.subsystem.BitrateReader;
import FacadeDecorator.learn.Facade.subsystem.CodecFactory;
import FacadeDecorator.learn.Facade.subsystem.VideoFile;
import FacadeDecorator.learn.Facade.subsystem.codecs.VideoCodec;

public class VideoConverter {
    private AudioMixer audioMixer;

    public VideoConverter() {
        this.audioMixer = new AudioMixer();
    }

    public String convert(String filename, String targetFormat) {
        System.out.println("\n🎬 === НАЧАЛО КОНВЕРТАЦИИ ===");
        System.out.println("🎬 Файл: " + filename + " → Формат: " + targetFormat);

        try {
            // Шаг 1: Анализ исходного файла
            VideoFile sourceFile = new VideoFile(filename);
            System.out.println("📋 Информация о файле: " + sourceFile);

            // Шаг 2: Определение кодеков
            VideoCodec sourceCodec = CodecFactory.extract(sourceFile);
            VideoCodec destinationCodec = CodecFactory.createCodecForFormat(targetFormat);

            // Шаг 3: Чтение и конвертация видео
            String videoBuffer = BitrateReader.read(filename, sourceCodec);
            String convertedVideo = BitrateReader.convert(videoBuffer, sourceCodec, destinationCodec);

            // Шаг 4: Обработка аудио
            String withAudio = audioMixer.fixAudio(convertedVideo);
            String normalized = audioMixer.normalizeAudio(withAudio);

            System.out.println("✅ === КОНВЕРТАЦИЯ УСПЕШНО ЗАВЕРШЕНА ===");
            return normalized;

        } catch (Exception e) {
            System.out.println("❌ === ОШИБКА КОНВЕРТАЦИИ: " + e.getMessage() + " ===");
            return null;
        }
    }

    public String convertWithEffects(String filename, String targetFormat) {
        String result = convert(filename, targetFormat);
        if (result != null) {
            return audioMixer.addSoundEffects(result);
        }
        return null;
    }

    public void getSupportedFormats() {
        System.out.println("\n📋 Поддерживаемые форматы конвертации:");
        System.out.println("   • MP4 (MPEG-4)");
        System.out.println("   • OGG (Ogg Theora)");
    }
}