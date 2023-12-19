package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	Cart cart;
	Store store;

	public CartController(Store store,Cart cart) {
		this.cart = cart;
		this.store = store;
	}

	@FXML
	public void initialize() {
		
		
		
		costLabel.setText(cart.totalCost()+" $");
		
		colMediaId.setCellValueFactory(
				new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemsOrdered()!=null)
			tblMedia.setItems(cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}			
			
			void updateButtonBar (Media media) {
				if(media==null) {
					btnPlay.setVisible(false);
					btnRemove.setVisible(false);			
				}else {
					btnRemove.setVisible(true);
					if (media instanceof Playable) {
						btnPlay.setVisible(true);
					} else {
						btnPlay.setVisible(false);
					}
				}
			}			
		});
		

		
//		tfFilter.textProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				showFilteredBar(newValue);
//			}
//
//			private void showFilteredBar(String newValue) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
		tblMedia.setItems(filteredList);
		
		
		filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		    @Override
		    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
		        if (newValue == null) {
		            return;
		        }
		        
		        if (radioBtnFilterId.isSelected()) {
		            tfFilter.textProperty().addListener((obs, old, newval) -> {
		                filteredList.setPredicate(media -> {
		                    if (newval == null || newval.isEmpty()) {
		                        return true;
		                    }
		                    return String.valueOf(media.getId()).contains(newval);
		                });
		            });
		        } else if (radioBtnFilterTitle.isSelected()) {
		            tfFilter.textProperty().addListener((table, old, newval) -> {
		                filteredList.setPredicate(media -> {
		                    if (newval == null || newval.isEmpty()) {
		                        return true;
		                    }
		                    return media.getTitle().toLowerCase().contains(newval.toLowerCase());
		                });
		            });
		        }
		    }
		});
	}
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private RadioButton radioBtnFilterTitle;
	
	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private Label costLabel;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		PlayMediaSceneUtil.playMedia(media);
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}

//    @FXML
//    void 004cff(ActionEvent event) {
//
//    }

	
	
	@FXML
	void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
	    		fxmlLoader.setController(new ViewStoreController(store, cart));
	    		Parent root = fxmlLoader.load();
	    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	    		stage.setScene(new Scene(root));
	    		stage.setTitle("Store");
	    		stage.show();
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
