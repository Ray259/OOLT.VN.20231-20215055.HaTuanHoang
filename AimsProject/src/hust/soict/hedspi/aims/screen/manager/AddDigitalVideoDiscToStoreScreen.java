package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField lengthField;
	private JTextField directorField;

	private Store store;

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);

		// Fields
		this.store = store;
		lengthField = new JTextField(20);
		directorField = new JTextField(20);

		JPanel mainPanel = (JPanel) getContentPane().getComponent(0);
		mainPanel.add(new JLabel("Length:"));
		mainPanel.add(lengthField);
		mainPanel.add(new JLabel("Director:"));
		mainPanel.add(directorField);

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

			store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
		}
	}
}