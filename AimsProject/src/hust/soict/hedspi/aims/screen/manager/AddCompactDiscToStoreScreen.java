package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField lengthField; 
	private JTextField directorField;
	private JTextField artistField;
	private JTextField tracksField;
	private JTextField tracksTitle;
	private JTextField tracksLength;
	
	private Store store;

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);

		// Fields
		this.store = store; 
		lengthField = new JTextField(20);
		directorField = new JTextField(20);
		artistField = new JTextField(20);
		tracksTitle = new JTextField(20);
		tracksLength = new JTextField(20);

		JPanel mainPanel = (JPanel) getContentPane().getComponent(0);
		mainPanel.add(new JLabel("Length:"));
		mainPanel.add(lengthField);
		mainPanel.add(new JLabel("Director:"));
		mainPanel.add(directorField);
		mainPanel.add(new JLabel("Artist:"));
		mainPanel.add(artistField);
		mainPanel.add(new JLabel("Track's title:"));
		mainPanel.add(tracksTitle);
		mainPanel.add(new JLabel("Track's length:"));
		mainPanel.add(tracksLength);
		
        JButton submitButton = new JButton("Submit");
        mainPanel.add(submitButton);
        InputListener inputListener = new InputListener();
        submitButton.addActionListener(inputListener);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        String title = getTitleFieldValue();
        String category = getCategoryFieldValue();
        float cost = getCostFieldValue();
        
		int length = Integer.parseInt(lengthField.getText());
		String director = directorField.getText();
		String artist = artistField.getText();
		
		ArrayList<Track> tracks = new ArrayList<>();
		
		int aTrackLength = Integer.parseInt(tracksLength.getText());
		String aTrackTitle = tracksTitle.getText();
		tracks.add(new Track(aTrackTitle, aTrackLength ));

		store.addMedia(new CompactDisc(title, category, director, length, cost, artist, tracks));	
        }
    }
}