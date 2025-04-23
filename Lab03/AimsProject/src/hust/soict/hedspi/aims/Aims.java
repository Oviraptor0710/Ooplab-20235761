package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 0 -> {
                    System.out.println("Thank you for using AIMS. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        store.printStore();
        storeMenu();
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.findByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsMenu(media);
                    } else {
                        System.out.println("Media not found.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter media title to add to cart: ");
                    String title = scanner.nextLine();
                    Media media = store.findByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Added to cart. Cart size: " + cart.getItemsOrdered().size());
                    } else {
                        System.out.println("Media not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter media title to play: ");
                    String title = scanner.nextLine();
                    Media media = store.findByTitle(title);
                    if (media instanceof Playable playable) {
                        playable.play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 4 -> cart.printCart();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Added to cart.");
            } else if (choice == 2 && media instanceof Playable playable) {
                playable.play();
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static void updateStore() {
        System.out.println("\nUpdate store:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        if (choice == 1) {
            Media media = new DigitalVideoDisc(title, "Unknown", 10.0f); // basic example
            store.addMedia(media);
            System.out.println("Media added.");
        } else if (choice == 2) {
            Media media = store.findByTitle(title);
            if (media != null) {
                store.removeMedia(media);
                System.out.println("Media removed.");
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    public static void seeCurrentCart() {
        cart.printCart();
    }
}