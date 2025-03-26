public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added: " + disc.getTitle());
        } else {
            System.out.println("The cart is almost full. Cannot add more items.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                // Shift the elements to remove the DVD
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    public void displayCart() {
        System.out.println();
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-2d %-20s %.2f\n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }
        System.out.printf("\n%13s %15.2f\n", "Total Cost", totalCost());
    }
}
