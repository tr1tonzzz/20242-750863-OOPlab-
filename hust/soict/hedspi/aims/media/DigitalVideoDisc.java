package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title) {
        this(title, "", null, 0, 0);
    }

    public void play() throws PlayerException {
    	if (this.getLength() > 0) {
    		System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
    	} else {
    	throw new PlayerException("ERROR: DVD length is non-positive!");
    	}
    	}
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCost() + "$";
    }
}
