package FacadeDecorator.learn.Facade.subsystem;

import FacadeDecorator.learn.Facade.subsystem.codecs.MPEG4CompressionCodec;
import FacadeDecorator.learn.Facade.subsystem.codecs.OggCompressionCodec;
import FacadeDecorator.learn.Facade.subsystem.codecs.VideoCodec;

public class CodecFactory {

    public static VideoCodec extract(VideoFile file) {
        System.out.println("🔧 Извлечение кодека из файла: " + file.getFilename());

        String format = file.getFormat().toLowerCase();
        switch (format) {
            case "mp4":
            case "m4v":
            case "mov":
                return new MPEG4CompressionCodec();
            case "ogg":
            case "ogv":
            case "ogx":
                return new OggCompressionCodec();
            default:
                throw new IllegalArgumentException("❌ Неподдерживаемый формат видео: " + format);
        }
    }

    public static VideoCodec createCodecForFormat(String format) {
        System.out.println("🔧 Создание кодек для формата: " + format);

        switch (format.toLowerCase()) {
            case "mp4":
                return new MPEG4CompressionCodec();
            case "ogg":
                return new OggCompressionCodec();
            default:
                throw new IllegalArgumentException("❌ Неподдерживаемый целевой формат: " + format);
        }
    }
}