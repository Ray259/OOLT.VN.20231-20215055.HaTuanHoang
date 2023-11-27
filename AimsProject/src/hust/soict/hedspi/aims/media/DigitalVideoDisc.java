package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	
	//Constructor
	public DigitalVideoDisc(String title) {
		super(title);
	
	}
	

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
        // Increment the class variable and assign a unique ID to this DVD
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
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
    public void play() {
    	System.out.println("Playing DVD: "+this.getTitle());
    	System.out.println("DVD length: "+ this.getLength());
    }
	
    
	// Getter, setter
	public int getId() {
        return id;
    }
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
}
