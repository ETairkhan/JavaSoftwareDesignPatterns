package FacadeDecorator.learn.Facade.subsystem;

public class VideoFile {
    private String filename;
    private String format;
    private long fileSize;

    public VideoFile(String filename) {
        this.filename = filename;
        // Извлекаем формат из расширения файла
        int dotIndex = filename.lastIndexOf('.');
        this.format = (dotIndex > 0) ? filename.substring(dotIndex + 1) : "unknown";
        this.fileSize = filename.length() * 100L; // Имитация размера файла
    }

    public String getFilename() {
        return filename;
    }

    public String getFormat() {
        return format;
    }

    public long getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return String.format("VideoFile{filename='%s', format='%s', size=%d bytes}",
                filename, format, fileSize);
    }
}