package FacadeDecorator.learn.Facade.subsystem;

import FacadeDecorator.learn.Facade.subsystem.codecs.VideoCodec;

public class BitrateReader {

    public static String read(String filename, VideoCodec sourceCodec) {
        System.out.println("📖 Чтение файла: " + filename);
        System.out.println("📖 Используемый кодек: " + sourceCodec.getName());

        // Имитация чтения видео данных
        String videoData = "VIDEO_DATA_FROM_" + filename.replace(".", "_");
        return sourceCodec.decompress(videoData);
    }

    public static String convert(String buffer, VideoCodec sourceCodec, VideoCodec destinationCodec) {
        System.out.println("🔄 Конвертация видео");
        System.out.println("🔄 Исходный формат: " + sourceCodec.getFormat());
        System.out.println("🔄 Целевой формат: " + destinationCodec.getFormat());

        // Сначала разжимаем исходными кодеком, потом сжимаем целевым
        String rawData = sourceCodec.decompress(buffer);
        return destinationCodec.compress(rawData);
    }
}
