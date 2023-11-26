package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	
	//create constructor
	public DigitalVideoDisc(String title) {
		super(title);
	
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
        // Increment the class variable and assign a unique ID to this DVD
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	
	// Get the instance and class attribute
	public int getId() {
        return id;
    }
	
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    
    // toString method to convert the DVD object to a string contain its information
    @Override
    public String toString() {
    	String string = "DVD:"+ 
    						"\n Title: "+this.getTitle()+","+
    						"\n Category: "+this.getCategory()+","+
                			"\n Director: "+this.getDirector()+","+
                			"\n Length: "+this.getLength()+","+
                			"\n*Cost: "+this.getCost()+" $ \n";
    	return string;
    }
    

    
    // Play method
    public void play() {
    	System.out.println("Playing DVD: "+this.getTitle());
    	System.out.println("DVD length: "+ this.getLength());
    }
	
	private String director;
	private int length;
	// Instance attribute 
	private int id;
	// Class attribute
	private static int nbDigitalVideoDiscs = 0;
	
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
