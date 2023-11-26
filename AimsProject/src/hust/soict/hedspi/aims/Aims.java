package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	//All Menu
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
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
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	
// Choosing Options
	
	// Options from 4 main menu
	// Main menu 
	public static void start(Store aStore, Cart anOrder) {
		showMenu();
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt(); sc.nextLine();
		sc.close();
		switch (c) {
		case 0:
			System.out.println("\n Exit Aims...");
			break;
		case 1: 
			aStore.viewStore();
			choosingStoreMenu(aStore, anOrder);
			break;
		case 2:
			updateStore(aStore, anOrder);
			break;
		case 3:
			seeCurrentCart(anOrder);
			break;
	}}
	
	

	// Store Menu
	public static void choosingStoreMenu(Store aStore, Cart anOrder) {
		storeMenu();
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		sc.close();
		switch (c) {
		case 0:
			System.out.println("\n Returned to main menu.");
			start(aStore, anOrder);
			break;
		case 1:  //see details of a media
			System.out.println("\n See details for item: ");
			Media m = validMediaStore(aStore);
			choosingMediaDetailsMenu(aStore, anOrder, m);
			break;
		case 2:
			//add a media to cart
			m = validMediaStore(aStore);
			anOrder.addMedia(m);
			System.out.println("\n Added");
			break;
		case 3:			
			//play a media
			m = validMediaStore(aStore);
			playMedia(m);
			break;
		case 4:
			//see current cart
			anOrder.displayCart();
			break;
	}}
	
	
	
	// Media Details Menu
	public static void choosingMediaDetailsMenu(Store aStore, Cart anOrder, Media m) {
		mediaDetailsMenu();
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		sc.close();
		switch (c) {
		case 0:
			System.out.println("\n Returned to Store Menu.");
			choosingStoreMenu(aStore, anOrder);
			break;
		case 1: //add to cart
			anOrder.addMedia(m);
			System.out.println("\n Added");
			break;
		case 2: // play
			if(!playMedia(m)) {
				choosingMediaDetailsMenu(aStore, anOrder, m);
			}
			break;
	}}
	
	// Cart Menu
	public static void choosingCartMenu(Store aStore, Cart anOrder) {
		cartMenu();
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		sc.close();
		switch(c) {
		case 0:
			start(aStore, anOrder);
			break;
		case 1: // filter media cart
		case 2: // sort media cart
		case 3: // remove media from cart
		case 4: // play a media
		case 5: // place order
		}
	}
	
	
	// Input and execute Options:

		// Update Store
		public static void updateStore(Store aStore, Cart anOrder) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n How would you like to update the store? \n 1. Add a media \n 2. Remove a media");
			int c = sc.nextInt(); sc.nextLine();
			sc.close();
			switch (c) {
			case 1:
				addMediaStore(aStore, anOrder);
			case 2:
				removeMediaStore(aStore);
			}
		}
		
		public static void addMediaStore(Store aStore, Cart anOrder) {		
			Scanner sc = new Scanner(System.in);
			System.out.println("\n Which type of Media would you like to add? \n 1. Book \n 2. DVD \n 3. CD");
			int c = sc.nextInt(); sc.nextLine();
			System.out.println("Enter the title: ");
			String title = sc.nextLine();
			System.out.println("Enter the category: ");
			String category = sc.nextLine();
			System.out.println("Enter the cost: ");
			float cost = sc.nextFloat(); sc.nextLine();
			switch (c) {
			case 1:
				System.out.println("Enter the authors: ");
				ArrayList<String> authors = new ArrayList<String>();				
				authors.add(sc.nextLine());				
				aStore.addMedia(new Book(title, category, authors, cost));
				start(aStore, anOrder);
				break;
			case 2:
				System.out.println("Enter the director: ");
				String director = sc.nextLine();
				System.out.println("Enter the length: ");
				int length = sc.nextInt(); sc.nextLine();
				aStore.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				start(aStore, anOrder);
				break;
			case 3:
				System.out.println("Enter the director: ");
				String dir = sc.nextLine();
				System.out.println("Enter the length: ");
				int lng = sc.nextInt(); sc.nextLine();
				System.out.println("Enter the artist: ");
				String artist = sc.nextLine();			
				System.out.println("Enter the track: ");
				ArrayList<Track> tracks = new ArrayList<Track>();
				
				System.out.println("Enter track's name: ");
				String trackTitle=sc.nextLine();
				System.out.println("Enter track's length: ");
				int trackLength = sc.nextInt(); sc.nextLine();
				tracks.add(new Track(trackTitle, trackLength));
				
				aStore.addMedia(new CompactDisc(title, category, dir, lng, cost, artist, tracks));
				start(aStore, anOrder);
				break;
			}
		}
		public static void removeMediaStore(Store aStore) {
			Media m = validMediaStore(aStore);
			aStore.removeMedia(m);
			System.out.println("\n Removed sucessful.");
		}
		
		// Loop check if media with a title exist
		public static Media validMediaStore(Store aStore) {
			Media m =null;
			Scanner sc = new Scanner(System.in);
			while(m==null) {
				System.out.println("Enter the title: ");
				String title = sc.nextLine();
				m = aStore.search(title);
				if (m==null) System.out.println("Not available in store");
			}
			sc.close();
			return m;
		}
		
		// Play a media
		public static boolean playMedia(Media m) {
			if (m instanceof DigitalVideoDisc || m instanceof CompactDisc) {
				((Playable) m).play();
				return true;
			} else {
				System.out.println("Playing is not available for this item.");			
				return false;
			}
		}
		
		
		// 3. See current Cart
		public static void seeCurrentCart(Cart anOrder) {
			
		}
		
	
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Store aStore = new Store();
		start(aStore, anOrder);
		
	}
}
