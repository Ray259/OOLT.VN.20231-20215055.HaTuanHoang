package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Options {
    private static Scanner sc = new Scanner(System.in);
    
    public static void start(Store aStore, Cart anOrder) throws PlayerException {
        Menu.showMainMenu();

        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {
            case 0:
                System.out.println("\n Exit Aims...");
                return;
            case 1:
            	// View Store
                aStore.viewStore();
                choosingStoreMenu(aStore, anOrder);
                start(aStore, anOrder);
                break;
            case 2:
            	// Update Store
            	choosingUpdateStore(aStore, anOrder);
                start(aStore, anOrder);
                break;
            case 3:
            	// See current Cart
            	anOrder.print();
            	choosingCartMenu(aStore, anOrder);
                break;
            default:
                System.out.println("Invalid choice!");
                Options.start(aStore, anOrder);
                break;
        }
    }

    public static void choosingStoreMenu(Store aStore, Cart anOrder) throws PlayerException {
        Menu.showStoreMenu();

        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {
            case 0:
                System.out.println("\n Returned to main menu.");
                Options.start(aStore, anOrder);
                break;
            case 1:
                // see details of a media
                System.out.println("\n See details for item: ");
                Media m = Handler.validMediaAims(aStore);
                choosingMediaDetailsMenu(aStore, anOrder, m);
                break;
            case 2:
                // add a media to cart
                m = Handler.validMediaAims(aStore);
                anOrder.addMedia(m);
                System.out.println("\n Added");
                choosingStoreMenu(aStore, anOrder);
                break;
            case 3:
                // play a media in store
                m = Handler.validMediaAims(aStore);
                Handler.playMediaAims(m);
                choosingStoreMenu(aStore, anOrder);
                break;
            case 4:
                // see current cart
                anOrder.displayCart();
                choosingStoreMenu(aStore, anOrder);
                break;
            default:
                System.out.println("Invalid choice!");
                choosingStoreMenu(aStore, anOrder);
                break;
        }
    }

    public static void choosingMediaDetailsMenu(Store aStore, Cart anOrder, Media m) throws PlayerException {
        Menu.showMediaDetailsMenu();

        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {
            case 0:
                System.out.println("\n Returned to Store Menu.");
                choosingStoreMenu(aStore, anOrder);
                break;
            case 1:
                // add to cart
                anOrder.addMedia(m);
                System.out.println("\n Added");
                break;
            case 2:
                // play the current media 
                Handler.playMediaAims(m);
                break;
            default:
            	System.out.println("Invalid choice!");
            	choosingMediaDetailsMenu(aStore, anOrder, m);
            	break;
        }
    }

    public static void choosingUpdateStore(Store aStore, Cart anOrder) throws PlayerException {
        System.out.println("\n How would you like to update the store? \n 1. Add a media \n 2. Remove a media");
        int c = sc.nextInt();
        sc.nextLine();
        switch (c) {
            case 1:
            	// Add a media to store
            	choosingMediaToAdd(aStore, anOrder);
            	Options.start(aStore, anOrder);
                break;
            case 2:
            	// Remove a media from store
            	Handler.removeMediaAims(aStore);
                Options.start(aStore, anOrder);
                break;
            default:
            	System.out.println("Invalid choice!");
            	choosingUpdateStore(aStore, anOrder);
            	break;
        }
    }
    
    public static void choosingMediaToAdd(Store aStore, Cart anOrder) {
        System.out.println("\n Which type of Media would you like to add? \n 1. Book \n 2. DVD \n 3. CD");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the title: ");
        String title = sc.nextLine();
        System.out.println("Enter the category: ");
        String category = sc.nextLine();
        System.out.println("Enter the cost: ");
        float cost = sc.nextFloat();
        sc.nextLine();
        Handler.addMediaStoreAims(aStore, c, title, category, cost);
    }
    
    public static void choosingCartMenu(Store aStore, Cart anOrder) throws PlayerException {
    	Menu.showCartMenu();
    	int c=sc.nextInt();
    	sc.nextLine();
    	switch(c) {
    	case 1:
    		//filter media in cart
    		Media m = Handler.validMediaAims(anOrder);
    		anOrder.search(m.getTitle());
    		break;
    	case 2:
    		//sort media in cart
    		Handler.sortMediaInCart(anOrder);
    		anOrder.print();
    		choosingCartMenu(aStore, anOrder);
    		break;
    	case 3:
    		//remove media from cart
    		Handler.removeMediaAims(anOrder);
    		choosingCartMenu(aStore, anOrder);
    		break;
    	case 4:
    		//play a media in cart
            m = Handler.validMediaAims(anOrder);
            Handler.playMediaAims(m);
    		break;
    	case 5:
    		System.out.println("Developing feature.");
    		choosingCartMenu(aStore, anOrder);
    		break;
    	default:
        	System.out.println("Invalid choice!");
        	choosingCartMenu(aStore, anOrder);
        	break;
    	}
    }
}
