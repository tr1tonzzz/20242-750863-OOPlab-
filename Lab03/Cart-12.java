package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added: " + media.getTitle());
        } else {
            System.out.println("The cart is almost full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println();
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.printf("%-2d %-20s %.2f\n", i++, media.getTitle(), media.getCost());
        }
        System.out.printf("\n%13s %15.2f\n", "Total Cost", totalCost());
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.printf("%d. Media - [%s] - [%s] : [%.2f] $\n",
                    i++, media.getTitle(), media.getCategory(), media.getCost());
        }
        System.out.printf("Total cost: [%.2f]\n", totalCost());
        System.out.println("*************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found Media: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No Media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found Media: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Media found with title containing: " + title);
        }
    }
}
