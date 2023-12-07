package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

abstract class AddItemToStoreScreen extends JFrame {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    
    private Store store;
    
    public AddItemToStoreScreen(Store store) {
    	// Fields
    	this.store = store;
        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        costField = new JTextField(20);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10, 2));
        
        mainPanel.add(new JLabel("Title:"));
        mainPanel.add(titleField);
        mainPanel.add(new JLabel("Category:"));
        mainPanel.add(categoryField);
        mainPanel.add(new JLabel("Cost:"));
        mainPanel.add(costField);

        
        setTitle("Add Item to Store");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(mainPanel);

        setVisible(true);
    }


    
    public String getTitleFieldValue() {
        return titleField.getText();
    }
    public String getCategoryFieldValue() {
        return categoryField.getText();
    }
    public float getCostFieldValue() {
        return Float.parseFloat(costField.getText());
    }
}
