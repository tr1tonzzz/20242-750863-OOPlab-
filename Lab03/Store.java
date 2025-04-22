package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_DVDS_IN_STORE = 100; // Maximum number of DVDs in the store
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_DVDS_IN_STORE];
    private int qtyInStore = 0; // Number of DVDs currently in the store

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_DVDS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD has been added to the store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Shift elements to remove the DVD
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD has been removed from the store: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the store: " + dvd.getTitle());
        }
    }

    // Helper method to display the store contents (for testing purposes)
    public void displayStore() {
        System.out.println("Items in Store:");
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.printf("%d. %s\n", (i + 1), itemsInStore[i].getTitle());
            }
        }
        System.out.println("Total DVDs in store: " + qtyInStore);
    }
}