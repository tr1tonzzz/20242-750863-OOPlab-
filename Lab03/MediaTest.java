package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Science Fiction", "Wachowski", 120, 18.99f);
        Book book = new Book(2, "Clean Code", "Programming", 30.00f);
        CompactDisc cd = new CompactDisc(3, "Hybrid Theory", "Rock", 50.00f, "Joe Hahn", 48, "Linkin Park");

        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
