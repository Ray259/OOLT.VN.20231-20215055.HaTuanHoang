package hust.soict.hedspi.test.screen.customer.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCart extends Application {
	private static Cart cart;
	private static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		System.out.println(getClass().getResource(CART_FXML_FILE_PATH));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController viewStoreController = new CartController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		cart = new Cart();
		
		
		ArrayList<String> authorList = new ArrayList<String>();
		authorList.add("Paulo Coelho");
		cart.addMedia(new Book("The Alchemist","Fiction", authorList, 20f));
		cart.addMedia(new Book("The Alchemist","Fiction", authorList, 20f));
		cart.addMedia(new Book("The Alchemist","Fiction", authorList, 20f));
		cart.addMedia(new Book("The Alchemist","Fiction", authorList, 20f));
		cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		cart.addMedia(new Book("The Alchemist","Fiction", authorList, 20f));
		
		launch(args);
	}
	
}
