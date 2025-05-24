package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);

        // Test the addDVD method
        System.out.println("Testing addDVD() method:");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.displayStore();

        // Test the removeDVD method
        System.out.println("\nTesting removeDVD() method:");
        store.removeMedia(dvd2); // Remove Star Wars
        store.displayStore();

        // Test removing a DVD that’s not in the store
        System.out.println("\nTesting removeDVD() with a non-existent DVD:");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", 
                "Fantasy", "Chris Columbus", 152, 22.99f);
        store.removeMedia(dvd4); // Should fail
        store.displayStore();

        // Test adding DVDs to a full store (optional edge case)
        System.out.println("\nTesting addDVD() with a full store:");
        Store fullStore = new Store();
        for (int i = 0; i < 100; i++) {
            fullStore.addMedia(new DigitalVideoDisc("DVD " + (i + 1), "Test", 10.0f));
        }
        // This should fail as the store is full
        fullStore.addMedia(new DigitalVideoDisc("Extra DVD", "Test", 10.0f));
    }
}