package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;  
import hust.soict.hedspi.aims.cart.Cart;
public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        cart.addMedia(dvd3);


        System.out.println("Testing print() method:");
        cart.print();
        System.out.println("\nTesting displayCart() method:");
        cart.displayCart();

        System.out.println("\nTesting totalCost() method:");
        System.out.printf("Total cost: %.2f\n", cart.totalCost());

        // Test the searchById method
        System.out.println("\nTesting searchById() method:");
        System.out.println("Search for ID 1 (should find The Lion King):");
        cart.searchById(1);
        System.out.println("Search for ID 5 (should not find):");
        cart.searchById(5);

        System.out.println("\nTesting searchByTitle() method:");
        System.out.println("Search for title 'lion' (should find The Lion King):");
        cart.searchByTitle("lion");
        System.out.println("Search for title 'wars' (should find Star Wars):");
        cart.searchByTitle("wars");
        System.out.println("Search for title 'harry' (should not find):");
        cart.searchByTitle("harry");

        System.out.println("\nTesting removeDigitalVideoDisc() method:");
        System.out.println("Removing Aladin:");
        cart.removeMedia(dvd3);
        System.out.println("Cart after removal:");
        cart.print();

        System.out.println("\nTesting addDigitalVideoDisc() with a nearly full cart:");
        Cart fullCart = new Cart();
        for (int i = 0; i < 20; i++) {
            fullCart.addMedia(new DigitalVideoDisc("DVD " + (i + 1), "Test", 10.0f));
        }

        fullCart.addMedia(new DigitalVideoDisc("Extra DVD", "Test", 10.0f));
    }
}