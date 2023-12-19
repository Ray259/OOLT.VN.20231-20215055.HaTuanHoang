package hust.soict.hedspi.aims.screen.customer.controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PlayMediaController {
	
	public PlayMediaController(List<String> titles, List<Integer> lengths) {
		this.titles=titles;
		this.lengths=lengths;
	}
	
	private List<String> titles;
	private List<Integer> lengths;
	
    @FXML
    private ListView<String> listViewMedia;
	@FXML
	private Button btnClosePlay;
    @FXML
    private void closePlayMedia() {
        ((Stage) btnClosePlay.getScene().getWindow()).close();
    }
    
    @FXML
    private void initialize() {
    	int i=0;
    	for(String title : titles) {
    		String message =">> Playing media "+title+" with the length of "+lengths.get(i);
    		i++;
    		listViewMedia.getItems().add(message);
    		listViewMedia.getItems().add("Media ended...");
    	}
        
    }
}
