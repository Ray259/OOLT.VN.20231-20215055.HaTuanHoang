package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    JMenuItem viewStore = new JMenuItem("View Store");
	    viewStore.addActionListener(new InputListener());
	    menu.add(viewStore);

	    JMenu smUpdateStore = new JMenu("Update Store");

	    JMenuItem addBookMenuItem = new JMenuItem("Add Book");
	    addBookMenuItem.addActionListener(new InputListener());
	    smUpdateStore.add(addBookMenuItem);

	    JMenuItem addCDMenuItem = new JMenuItem("Add CD");
	    addCDMenuItem.addActionListener(new InputListener());
	    smUpdateStore.add(addCDMenuItem);

	    JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
	    addDVDMenuItem.addActionListener(new InputListener());
	    smUpdateStore.add(addDVDMenuItem);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);
	    menuBar.add(smUpdateStore);

	    return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
				
		return header;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (Media c : mediaInStore) {
			MediaStore cell = new MediaStore(c);
			center.add(cell);
		}
		return center;
	}
	

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	String button = e.getActionCommand();
            if (button.equals("View Store")) {
            	dispose();
                new StoreManagerScreen(store);
            }
            if (e.getActionCommand().equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store);
            }            
            if (e.getActionCommand().equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
            if (e.getActionCommand().equals("Add Book")) {
                new AddBookToStoreScreen(store);
            }
        }
    }
}
