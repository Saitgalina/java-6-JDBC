package myServlets;

public class FileDescription {
    String fileName;
    String link;
    String fileSize;
    String date;
    boolean isDirectory;

    public FileDescription(String fileName, String link, String fileSize, String date, boolean isDirectory){
        this.fileName = fileName;
        this.link = link;
        this.fileSize = fileSize;
        this.date = date;
        this.isDirectory = isDirectory;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLink() {
        return link;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getDate() {
        return date;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}
