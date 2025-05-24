package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Aims {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3\n> ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4\n> ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2\n> ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5\n> ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        // Sample media to store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    viewStore(scanner, store, cart);
                    break;
                case 2:
                    updateStore(scanner, store);
                    break;
                case 3:
                    viewCart(scanner, cart);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void viewStore(Scanner scanner, Store store, Cart cart) {
        boolean inStore = true;
        while (inStore) {
            System.out.println("\n--- Store Items ---");
            for (int i = 0; i < store.getItemsInStore().size(); i++) {
                System.out.println((i + 1) + ". " + store.getItemsInStore().get(i).getTitle());
            }

            storeMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1: // See media details
                    System.out.print("Enter media number to view details: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (index >= 0 && index < store.getItemsInStore().size()) {
                        Media media = store.getItemsInStore().get(index);
                        System.out.println(media.toString());
                        mediaDetailsMenu();
                        int detailChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (detailChoice) {
                            case 1:
                                cart.addMedia(media);
                                System.out.println("Media added to cart.");
                                break;
                            case 2:
                                playMedia(media);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid input.");
                                break;
                        }
                    } else {
                        System.out.println("Invalid media selection.");
                    }
                    break;
                case 2: // Add media to cart
                    System.out.print("Enter media number to add to cart: ");
                    int addIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (addIndex >= 0 && addIndex < store.getItemsInStore().size()) {
                        cart.addMedia(store.getItemsInStore().get(addIndex));
                        System.out.println("Media added to cart.");
                    } else {
                        System.out.println("Invalid media selection.");
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter media number to play: ");
                    int playIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (playIndex >= 0 && playIndex < store.getItemsInStore().size()) {
                        Media media = store.getItemsInStore().get(playIndex);
                        playMedia(media);
                    } else {
                        System.out.println("Invalid media selection.");
                    }
                    break;
                case 4:
                    viewCart(scanner, cart);
                    break;
                case 0:
                    inStore = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void updateStore(Scanner scanner, Store store) {
        System.out.println("Update Store feature is not implemented.");
    }

    public static void viewCart(Scanner scanner, Cart cart) {
        System.out.println("Cart Items:");
        cart.print();
    }

    public static void playMedia(Media media) {
        try {
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else {
                System.out.println("This media type cannot be played.");
            }
        } catch (PlayerException e) {
            System.err.println("Playback error:");
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
