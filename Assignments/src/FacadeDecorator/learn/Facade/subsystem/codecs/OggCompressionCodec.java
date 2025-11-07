package FacadeDecorator.learn.Facade.subsystem.codecs;
public class OggCompressionCodec implements VideoCodec {

    @Override
    public String compress(String buffer) {
        System.out.println("📹 Сжатие видео в Ogg формате");
        return "[OGG_COMPRESSED]" + buffer;
    }

    @Override
    public String decompress(String buffer) {
        System.out.println("📹 Разжатие Ogg видео");
        return buffer.replace("[OGG_COMPRESSED]", "");
    }

    @Override
    public String getFormat() {
        return "ogg";
    }

    @Override
    public String getName() {
        return "Ogg Theora Video Codec";
    }
}