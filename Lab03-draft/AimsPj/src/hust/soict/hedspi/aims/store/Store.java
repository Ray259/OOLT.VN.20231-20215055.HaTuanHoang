package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
	private static final int MAX_ITEMS_IN_STORE = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	private int qtyStored = 0;
	
	public void addDVD(DigitalVideoDisc... dvdList) {
 		for (DigitalVideoDisc item : dvdList) {
				itemsInStore[qtyStored] = item;
 				System.out.println("**The disc '"+ item.getTitle() +"' has been added");
 			}	
	}
	
    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyStored; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < qtyStored - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];	 
                }		
                qtyStored--;
                System.out.println("The disc has been removed. "+qtyStored+" disc remained in cart.");
            }
        }
    }
}
