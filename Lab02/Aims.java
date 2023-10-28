
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
	
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Aimation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Aimation", null, 0, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		
		anOrder.displayCart();
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		//test remove items from cart
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.displayCart();	
		System.out.println("Current total cost is: ");
		System.out.println(anOrder.totalCost());
		
		//test adding a list of DVDs to the Cart
		DigitalVideoDisc[] dvdList = {
				new DigitalVideoDisc("Interstellar",
						"Science Fiction", "Christopher Nolan", 169, 20f),						
				new DigitalVideoDisc("Dune",
						"Science Fiction", "Denis Villeneuve", 156, 20f)
		};
		
		anOrder.addDigitalVideoDisc(dvdList);
		anOrder.displayCart();
		
	}
}
