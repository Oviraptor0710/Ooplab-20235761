package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {


    public static final int MAX_NUMBERS_ORDERED = 20;
    private final List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media item) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is full");
            return;
        }
        if (itemsOrdered.contains(item)) {
            System.out.println("Item already in cart: " + item.getTitle());
            return;
        }
        itemsOrdered.add(item);
        System.out.printf("Added \"%s\" to cart (%d/%d)%n", item.getTitle(), itemsOrdered.size(), MAX_NUMBERS_ORDERED);
    }


    public void removeMedia(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println("Removed \"" + item.getTitle() + "\" from cart.");
        } else {
            System.out.println("Item not found in cart: " + item.getTitle());
        }
    }


    public float totalCost() {
        float sum = 0f;
        for (Media m : itemsOrdered) sum += m.getCost();
        return sum;
    }

    public void printCart() {
        System.out.println("*********************** CART ***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is currently empty.");
        } else {
            System.out.println("Ordered items:");
            int idx = 1;
            for (Media m : itemsOrdered) {
                System.out.printf("%d. %s%n", idx++, m);
            }
            System.out.printf("Total cost: %.2f $%n", totalCost());
        }
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered)
            if (m.getId() == id) return m;
        return null;
    }

    public List<Media> searchByTitle(String title) {
        List<Media> result = new ArrayList<>();
        for (Media m : itemsOrdered)
            if (m.getTitle() != null &&
                    m.getTitle().equalsIgnoreCase(title.trim())) {
                result.add(m);
            }
        return result;
    }


    public List<Media> getItemsOrdered() {
        return Collections.unmodifiableList(itemsOrdered);
    }
}