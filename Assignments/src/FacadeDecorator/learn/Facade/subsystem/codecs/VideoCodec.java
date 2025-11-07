package FacadeDecorator.learn.Facade.subsystem.codecs;

// Интерфейс для видео кодеков
public interface VideoCodec extends Codec {
    String getFormat();
    String getName();
}