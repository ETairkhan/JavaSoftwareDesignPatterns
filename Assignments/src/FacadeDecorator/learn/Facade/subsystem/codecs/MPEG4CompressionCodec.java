package FacadeDecorator.learn.Facade.subsystem.codecs;


public class MPEG4CompressionCodec implements VideoCodec {

    @Override
    public String compress(String buffer) {
        System.out.println("📹 Сжатие видео в MPEG4 формате");
        return "[MPEG4_COMPRESSED]" + buffer;
    }

    @Override
    public String decompress(String buffer) {
        System.out.println("📹 Разжатие MPEG4 видео");
        return buffer.replace("[MPEG4_COMPRESSED]", "");
    }

    @Override
    public String getFormat() {
        return "mp4";
    }

    @Override
    public String getName() {
        return "MPEG-4 Video Codec";
    }
}