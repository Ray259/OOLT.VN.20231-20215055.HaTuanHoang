package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;


public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        Store aStore = new Store();
        Options.start(aStore, anOrder);
    }
}