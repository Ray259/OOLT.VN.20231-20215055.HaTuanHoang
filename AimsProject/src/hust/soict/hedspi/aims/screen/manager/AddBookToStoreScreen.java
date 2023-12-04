package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField authorsField;
	private Store store;

	public AddBookToStoreScreen(Store store) {
		super(store);

		// Fields
	    this.store = store;
		authorsField = new JTextField(20);

		JPanel mainPanel = (JPanel) getContentPane().getComponent(0);
		mainPanel.add(new JLabel("Authors:"));
		mainPanel.add(authorsField);

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

			String authorsInput = authorsField.getText();
			String[] authorsArray = authorsInput.split(","); // Assuming authors are comma-separated

			ArrayList<String> authors = new ArrayList<>();
			for (String author : authorsArray) {
				authors.add(author.trim());
			}

			store.addMedia(new Book(title, category, authors, cost));
		}
	}
}
