package hust.soict.hedspi.test.screen.customer.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static final Media DigitalVideoDisc = null;
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		System.out.println(getClass().getResource(STORE_FXML_FILE_PATH));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		
		
		
		ArrayList<String> authorList = new ArrayList<String>();
		authorList.add("Paulo Coelho");
		Book book = new Book("The Alchemist","Fiction", authorList, 20f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 0, 19.95f);
		Track track1 = new Track("Track 1", 120);
        Track track2 = new Track("Track 2", 180);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd = new CompactDisc("Sample Title", "Music", "John A", 300, 25f, "Jack B", tracks);

		
		store.addMedia(cd);
		store.addMedia(book);
		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(dvd);
		
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(dvd);
		cart.addMedia(book);
		launch(args);
	}
	
}
