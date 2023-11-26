

public class DigitalVideoDisc {
	
	//create constructor
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
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

	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	// Instance attribute 
	private int id;
	// Class attribute
	private static int nbDigitalVideoDiscs = 0;
	
	
	// Getter and setter
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
}
