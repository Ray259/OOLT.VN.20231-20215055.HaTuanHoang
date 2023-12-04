package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	

// 	Add, remove Media
	public void addMedia(Media m) {
	    for (Media o : itemsInStore) {
	        if (m.equals(o)) {
	            System.out.println("The Media " + m.getTitle() + " has already in the store");
	            return; // Exit the method if the media is already in the store
	        }
	    }
	    itemsInStore.add(m);
	    System.out.println("**The media '" + m.getTitle() + "' has been added");
	}
	
    public void removeMedia(Media m) {
    	for(Media media: itemsInStore) {
			if(media.getTitle() == m.getTitle()) {
				itemsInStore.remove(m);
				System.out.println("The disc has been removed");
			}
    	}
    }
    
    
    // View Store
    public void viewStore() {
    		System.out.println("\n***********************STORE**********************");
    		int i = 0;
            for (Media o : this.itemsInStore) {
            	i++;
                System.out.printf(i+". "+o.toString()+"\n");                     
            }
    		System.out.println("***************************************************\n");
    }
    
	//Search for Media by title
	public Media search(String title) {
		
	    System.out.println("\n******************Search result******************");
	    for (Media o : this.itemsInStore) {	      	        
	        if (o.isMatch(title)) {
	            System.out.printf(o.toString()+"\n 1 media found.");	           
	            return o;
	        }
	    }
	    System.out.println("\nNo matching item found with the name: " + title);
	    return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}
}
