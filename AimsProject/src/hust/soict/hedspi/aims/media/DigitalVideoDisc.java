package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	//Constructor
	public DigitalVideoDisc(String title) {
		super(title);
	
	}
	

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	//Attributes
	private int id; 	// Instance attribute 
	private static int nbDigitalVideoDiscs = 0;	// Class attribute
	
    // toString method to convert the DVD object to a string contain its information
    @Override
    public String toString() {
    	String string = "DVD:\n Title: "+this.getTitle()+
    						",\n Category: "+this.getCategory()+
                			",\n Director: "+this.getDirector()+
                			",\n Length: "+this.getLength()+
                			",\n*Cost: "+this.getCost()+" $ \n";
    	return string;
    }
    
 
    // play() method
    public void play() throws PlayerException {
    	if (this.getLength()>0) {
    	System.out.println("Playing DVD: "+this.getTitle());
    	System.out.println("DVD length: "+ this.getLength());
    } else {
    	throw new PlayerException("Error: DVD length is non-positive");
    }
    }
}
