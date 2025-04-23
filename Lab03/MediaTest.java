package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Science Fiction", "Wachowski", 120, 18.99f);
        Book book = new Book("Clean Code", "Programming", 30.00f);
        CompactDisc cd = new CompactDisc("Hybrid Theory", "Rock", "Linkin Park", 50.00f);

        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}

