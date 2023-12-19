package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
	
	private Media media;
	private List<Media> cart;
	public void setData(Media media, List<Media> cart) {
		this.cart = cart;
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost()+" $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
		}
	}
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	cart.add(media);
    }
    
    
    @FXML
    void btnPlayClicked(ActionEvent event) {
        PlayMediaSceneUtil.playMedia(media);
    }


}
