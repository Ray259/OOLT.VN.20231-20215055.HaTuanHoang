package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc {
	
	//create constructor
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(director, length);
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
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
    public String toString() {
    	String string = "DVD-["+ this.getTitle()+"]-["+this.getCategory()+
                "]-["+this.getDirector()+"]-["+this.getLength()+"]: "+this.getCost()+"$";
    	return string;
    }
    
    // isMatch method
    public boolean isMatch(String title) {
    	if(this.getTitle().equals(title)) return true;
    	return false;
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
