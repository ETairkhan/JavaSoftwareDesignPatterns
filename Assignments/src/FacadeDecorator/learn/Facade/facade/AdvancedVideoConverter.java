package FacadeDecorator.learn.Facade.facade;

import FacadeDecorator.learn.Facade.subsystem.AudioMixer;
import FacadeDecorator.learn.Facade.subsystem.BitrateReader;
import FacadeDecorator.learn.Facade.subsystem.CodecFactory;
import FacadeDecorator.learn.Facade.subsystem.VideoFile;
import FacadeDecorator.learn.Facade.subsystem.codecs.VideoCodec;

// Расширенная версия фасада с дополнительными функциями
public class AdvancedVideoConverter {
    private AudioMixer audioMixer;
    private int conversionCount;

    public AdvancedVideoConverter() {
        this.audioMixer = new AudioMixer();
        this.conversionCount = 0;
    }

    public ConversionResult convert(String filename, String targetFormat, boolean highQuality) {
        System.out.println("\n🎬 === РАСШИРЕННАЯ КОНВЕРТАЦИЯ ===");
        System.out.println("🎬 Файл: " + filename + " → Формат: " + targetFormat);
        if (highQuality) {
            System.out.println("🎬 Режим: Высокое качество");
        }

        long startTime = System.currentTimeMillis();

        try {
            VideoFile sourceFile = new VideoFile(filename);
            VideoCodec sourceCodec = CodecFactory.extract(sourceFile);
            VideoCodec destinationCodec = CodecFactory.createCodecForFormat(targetFormat);

            String videoBuffer = BitrateReader.read(filename, sourceCodec);
            String convertedVideo = BitrateReader.convert(videoBuffer, sourceCodec, destinationCodec);

            // Расширенная обработка аудио
            String withAudio = audioMixer.fixAudio(convertedVideo);
            String normalized = audioMixer.normalizeAudio(withAudio);
            String withEffects = audioMixer.addSoundEffects(normalized);

            if (highQuality) {
                withEffects = withEffects + "[HIGH_QUALITY]";
            }

            conversionCount++;
            long endTime = System.currentTimeMillis();

            System.out.println("✅ === РАСШИРЕННАЯ КОНВЕРТАЦИЯ УСПЕШНО ЗАВЕРШЕНА ===");

            return new ConversionResult(withEffects, true, "Конвертация успешна",
                    endTime - startTime, sourceFile.getFormat(), targetFormat);

        } catch (Exception e) {
            System.out.println("❌ === ОШИБКА КОНВЕРТАЦИИ: " + e.getMessage() + " ===");
            return new ConversionResult(null, false, e.getMessage(), 0, "", targetFormat);
        }
    }

    public int getConversionCount() {
        return conversionCount;
    }

    // Вложенный класс для результатов конвертации
    public static class ConversionResult {
        private final String data;
        private final boolean success;
        private final String message;
        private final long duration;
        private final String sourceFormat;
        private final String targetFormat;

        public ConversionResult(String data, boolean success, String message,
                                long duration, String sourceFormat, String targetFormat) {
            this.data = data;
            this.success = success;
            this.message = message;
            this.duration = duration;
            this.sourceFormat = sourceFormat;
            this.targetFormat = targetFormat;
        }

        // Геттеры
        public String getData() { return data; }
        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
        public long getDuration() { return duration; }
        public String getSourceFormat() { return sourceFormat; }
        public String getTargetFormat() { return targetFormat; }

        @Override
        public String toString() {
            return String.format("ConversionResult{success=%s, duration=%dms, source=%s, target=%s, message='%s'}",
                    success, duration, sourceFormat, targetFormat, message);
        }
    }
}