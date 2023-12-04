package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

public class StoreScreen {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Store aStore = new Store();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		aStore.addMedia(dvd);
		new StoreManagerScreen(aStore);
	}
}
