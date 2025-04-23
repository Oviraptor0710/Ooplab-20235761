package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media m) {
        if (itemsInStore.contains(m)) {
            System.out.println("Item already exists in store: " + m.getTitle());
            return;
        }
        itemsInStore.add(m);
        System.out.println("Added to store: " + m.getTitle());
    }

    public void removeMedia(Media m) {
        if (itemsInStore.remove(m)) {
            System.out.println("Removed from store: " + m.getTitle());
        } else {
            System.out.println("Item not found in store: " + m.getTitle());
        }
    }

    public void removeById(int id) {
        for (Media m : itemsInStore) {
            if (m.getId() == id) {
                removeMedia(m);
                return;
            }
        }
        System.out.println("No item with ID " + id + " in store.");
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void printStore() {
        System.out.println("===============  STORE INVENTORY  ===============");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            int index = 1;
            for (Media m : itemsInStore) {
                System.out.printf("%d. %s%n", index++, m);
            }
        }
        System.out.println("=================================================");
    }
}