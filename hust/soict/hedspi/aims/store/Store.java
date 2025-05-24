package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("The item has been added to the store: " + media.getTitle());
        } else {
            System.out.println("Cannot add null media to the store.");
        }
    }

    // Method to remove a Media item from the store
    public void removeMedia(Media media) {
        if (media != null && itemsInStore.remove(media)) {
            System.out.println("The item has been removed from the store: " + media.getTitle());
        } else {
            System.out.println("Item not found in the store or null media provided.");
        }
    }

    // Helper method to display the store contents (for testing purposes)
    public void displayStore() {
        System.out.println("Items in Store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            int index = 1;
            for (Media media : itemsInStore) {
                System.out.printf("%d. %s\n", index++, media.getTitle());
            }
        }
        System.out.println("Total items in store: " + itemsInStore.size());
    }

    // Method to get the list of items in the store
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}