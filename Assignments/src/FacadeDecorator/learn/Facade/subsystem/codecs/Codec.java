package FacadeDecorator.learn.Facade.subsystem.codecs;

// Базовый интерфейс для всех кодеков
public interface Codec {
    String compress(String buffer);
    String decompress(String buffer);
}