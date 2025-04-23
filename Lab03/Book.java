package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
}
