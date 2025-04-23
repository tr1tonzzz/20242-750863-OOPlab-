package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Media {
    private static int nbDigitalVideoDiscs = 0; // Track total DVDs
    private String director;
    private int length;
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost); // gọi constructor Media
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, "", 0);
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
