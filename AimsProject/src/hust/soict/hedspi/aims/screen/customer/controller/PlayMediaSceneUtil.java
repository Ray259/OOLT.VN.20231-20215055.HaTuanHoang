package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayMediaSceneUtil {
	public static void playMedia(Media media) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(media.getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/PlayMedia.fxml"));           
            ArrayList<String> titles = new ArrayList<>();
            ArrayList<Integer> lengths = new ArrayList<>();
            if (media instanceof DigitalVideoDisc) {
            	titles.add(media.getTitle());
            	lengths.add(((DigitalVideoDisc) media).getLength());
            } else if (media instanceof CompactDisc) {
            	
            	for (Track track : ((CompactDisc) media).getTracks()) {
            		titles.add(track.getTitle());
            		lengths.add(track.getLength());
            	}
            }
            

            fxmlLoader.setController(new PlayMediaController(titles, lengths));
            Parent popupPane = fxmlLoader.load();
            Stage popupStage = new Stage();
            popupStage.setTitle("Playing Media");
            popupStage.setScene(new Scene(popupPane));
            popupStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
