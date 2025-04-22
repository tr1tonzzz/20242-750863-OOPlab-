package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        System.out.println("Testing print() method:");
        cart.print();

        // Test the displayCart method
        System.out.println("\nTesting displayCart() method:");
        cart.displayCart();

        // Test the totalCost method
        System.out.println("\nTesting totalCost() method:");
        System.out.printf("Total cost: %.2f\n", cart.totalCost());

        // Test the searchById method
        System.out.println("\nTesting searchById() method:");
        System.out.println("Search for ID 1 (should find The Lion King):");
        cart.searchById(1);
        System.out.println("Search for ID 5 (should not find):");
        cart.searchById(5);

        // Test the searchByTitle method
        System.out.println("\nTesting searchByTitle() method:");
        System.out.println("Search for title 'lion' (should find The Lion King):");
        cart.searchByTitle("lion");
        System.out.println("Search for title 'wars' (should find Star Wars):");
        cart.searchByTitle("wars");
        System.out.println("Search for title 'harry' (should not find):");
        cart.searchByTitle("harry");

        // Test the removeDigitalVideoDisc method
        System.out.println("\nTesting removeDigitalVideoDisc() method:");
        System.out.println("Removing Aladin:");
        cart.removeDigitalVideoDisc(dvd3);
        System.out.println("Cart after removal:");
        cart.print();

        // Test adding a DVD to a nearly full cart (optional, for completeness)
        System.out.println("\nTesting addDigitalVideoDisc() with a nearly full cart:");
        Cart fullCart = new Cart();
        for (int i = 0; i < 20; i++) {
            fullCart.addDigitalVideoDisc(new DigitalVideoDisc("DVD " + (i + 1), "Test", 10.0f));
        }
        // The cart is full
        fullCart.addDigitalVideoDisc(new DigitalVideoDisc("Extra DVD", "Test", 10.0f));
    }
}