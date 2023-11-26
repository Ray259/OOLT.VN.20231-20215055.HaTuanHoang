package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;


import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0; // Field to track number of items in cart
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    
    public void addMedia(Media... mediaList) {
    	for(Media o : mediaList) {
    		itemsOrdered.add(o);
    		System.out.println("**The item '"+ o.getTitle() +"' has been successfully added to the cart.");
    	}
    }
    
    public void removeMedia(Media... mediaList) {
    	for(Media o : mediaList) {
    		itemsOrdered.remove(o);
    		System.out.println("**The item '"+ o.getTitle() +"' has been removed from the cart.");
    	}
    }
	//Search for Media by title
	public Media search(String title) {
		
	    System.out.println("\n******************Search result******************");
	    for (Media o : this.itemsOrdered) {	      	        
	        if (o.isMatch(title)) {
	            System.out.printf(o.toString()+"\n 1 media found.");	           
	            return o;
	        }
	    }
	    System.out.println("\nNo matching item found with the name: " + title);
	    return null;
	}
    
    
    // Total cost method
    public float totalCost() {
        float totalCost = 0.0f;
        for (Media o : itemsOrdered) {
        	totalCost += o.getCost();
        }
        return totalCost;
    }

	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	
	// Print the table of DVD in Cart
	public void displayCart() {
	        System.out.println("----------------------------------------------");
	        System.out.printf("| %-30s | %5s |\n", "--Name--", "Cost");
	
	        for (Media o : this.itemsOrdered) {	            
	            if (o != null) {
	                System.out.printf("| %-30s | %5.2f |\n", o.getTitle(), o.getCost());
	            }
	        }
	        System.out.printf("| %-30s | %5.2f |\n", "--Total Cost--", this.totalCost());
	        System.out.println("----------------------------------------------");
	}
	
	
	
	// New printing method
	public void print() {
		System.out.println("\n***********************CART***********************");
		int i = 0;
        for (Media o : this.itemsOrdered) {         
            System.out.printf((i+1)+o.toString()+"\n");                     
        }
        System.out.printf("Total cost: "+ this.totalCost()+ "\n");
		System.out.println("***************************************************\n");
	}
	
}

