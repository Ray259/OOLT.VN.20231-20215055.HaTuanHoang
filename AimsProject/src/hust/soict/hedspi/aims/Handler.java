package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Handler {
    private static Scanner sc = new Scanner(System.in);
    
    public static void addMediaStoreAims(Store aStore, int c, String title, String category, float cost) {
    	switch (c) {
        case 1:
            // add Book
            System.out.println("Enter the authors: ");
            ArrayList<String> authors = new ArrayList<>();
            authors.add(sc.nextLine());
            aStore.addMedia(new Book(title, category, authors, cost));
            break;
        case 2:
            // add DVD
            System.out.println("Enter the director: ");
            String director = sc.nextLine();
            System.out.println("Enter the length: ");
            int length = sc.nextInt();
            sc.nextLine();
            aStore.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
            break;
        case 3:
            // add CD
            System.out.println("Enter the director: ");
            String dir = sc.nextLine();
            System.out.println("Enter the length: ");
            int lng = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the artist: ");
            String artist = sc.nextLine();
            System.out.println("Enter the number of track(s): ");
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Track> tracks = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter track-" + i + "'s name: ");
                String trackTitle = sc.nextLine();
                System.out.println("Enter track-" + i + "'s length: ");
                int trackLength = sc.nextInt();
                sc.nextLine();
                tracks.add(new Track(trackTitle, trackLength));
            }
            aStore.addMedia(new CompactDisc(title, category, dir, lng, cost, artist, tracks));
            break;
    	}
    }

    //remove a media
    public static void removeMediaAims(Store aStore) {
    	//In Store
        Media m = validMediaAims(aStore);
        aStore.removeMedia(m);
        System.out.println("\n Removed successful.");
    }
    public static void removeMediaAims(Cart anOrder) {
    	//In Cart
        Media m = validMediaAims(anOrder);
        anOrder.removeMedia(m);
        System.out.println("\n Removed successful.");
    }

    
    // Loop input to check if a Media available and return that media object
    public static Media validMediaAims(Store aStore) {
    	//In store
        Media m = null;
        while (m == null) {
            System.out.println("Enter the title: ");
            String title = sc.nextLine();
            m = aStore.search(title);
            if (m == null) System.out.println("Item is not available in store, please try again.");
        }
        return m;
    }
    public static Media validMediaAims(Cart anOrder) {
    	//In cart
        Media m = null;
        while (m == null) {
            System.out.println("Enter the title: ");
            String title = sc.nextLine();
            m = anOrder.search(title);
            if (m == null) System.out.println("Item is not available in cart, please try again.");
        }
        return m;
    }
    
    
    // Play a media
    public static boolean playMediaAims(Media m) throws PlayerException {
        if (m instanceof Playable) {
            ((Playable) m).play();
            return true;
        } else {
            System.out.println("Playing is not available for this item.");
            return false;
        }
    }
    
    
    // Sort media in cart by 2 ways
    public static void sortMediaInCart(Cart anOrder) {
        System.out.println("How would you like to sort Medias in Cart \n1. By Title and Cost\n2. By Cost and Title");

        int c = sc.nextInt();
        sc.nextLine();

        switch (c) {
            case 1:
                Collections.sort(anOrder.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                System.out.println("Medias in cart sorted by Title and Cost");
                break;
            case 2:
                Collections.sort(anOrder.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                System.out.println("Medias in cart sorted by Cost and Title");
                break;
            default:
                System.out.println("Invalid sort type");
        }
    }
}