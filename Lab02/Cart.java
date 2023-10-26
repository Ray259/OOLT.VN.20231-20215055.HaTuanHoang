public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
    		new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private int qtyOrdered = 0; // Field to track number of items in cart

    // Add DVD method
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {	
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Remove DVD method
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];	 
                }		//Move other disc to cover the space of the removed disc
                qtyOrdered--;
                System.out.println("The disc has been removed. "+qtyOrdered+" disc remained in cart.");
            }
        }
    }

    // Total cost method
    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                totalCost += itemsOrdered[i].getCost();
            }
        }
        return totalCost;
    }

	public int getQtyOrdered() {
		return qtyOrdered;
	}
}
